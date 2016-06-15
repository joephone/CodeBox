/*
 * Copyright 2014 trinea.cn All right reserved. This software is the confidential and proprietary information of
 * trinea.cn ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with trinea.cn.
 */
package com.joephone.codebox.act.vpager.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jakewharton.salvage.RecyclingPagerAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * AdvertImagePagerAdapter
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-23
 */
public class AdvertImagePagerAdapter extends RecyclingPagerAdapter {

	private Context context;
	private List<Integer> imageIdList;
	private List<String> imageUrlList;
	private String [] imageUrls = new String[]{};
	private int size;
	private boolean isInfiniteLoop;
	private boolean flag;

	public AdvertImagePagerAdapter(Context context, List<Integer> imageIdList,boolean flag) {
		this.context = context;
		this.imageIdList = imageIdList;
		this.size = imageIdList.size();
		isInfiniteLoop = false;
		this.flag = flag;
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
	}

	public AdvertImagePagerAdapter(Context context, String [] imageUrls,boolean flag) {
		this.context = context;
		this.imageUrls = imageUrls;
		this.size = imageUrls.length;
		isInfiniteLoop = false;
		this.flag = flag;
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
	}

	@Override
	public int getCount() {
		// Infinite loop
		if(flag){
			return isInfiniteLoop ? Integer.MAX_VALUE : imageUrls.length;
		}
		return isInfiniteLoop ? Integer.MAX_VALUE : imageIdList.size();
	}

	/**
	 * get really position
	 * 
	 * @param position
	 * @return
	 */
	private int getPosition(int position) {
		return position % size;
	}

	@Override
	public View getView(int position, View view, ViewGroup container) {
		ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = holder.imageView = new ImageView(context);
			holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if(flag){
			ImageLoader.getInstance().displayImage(imageUrls[getPosition(position)], holder.imageView);
		}else {
			holder.imageView.setImageResource(imageIdList.get(getPosition(position)));
		}

		return view;
	}

	private static class ViewHolder {

		ImageView imageView;
	}

	/**
	 * @return the isInfiniteLoop
	 */
	public boolean isInfiniteLoop() {
		return isInfiniteLoop;
	}

	/**
	 * @param isInfiniteLoop the isInfiniteLoop to set
	 */
	public AdvertImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
		this.isInfiniteLoop = isInfiniteLoop;
		return this;
	}
}
