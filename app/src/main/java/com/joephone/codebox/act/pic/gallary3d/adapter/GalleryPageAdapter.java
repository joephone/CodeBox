package com.joephone.codebox.act.pic.gallary3d.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.joephone.codebox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class GalleryPageAdapter extends PagerAdapter {
    private String tag = this.getClass().getName();
    private ViewPager viewPager;
    private int pagerWidth;
    private int[] mImageIds;
    private Context mContext;
    private List<ImageView> viewlist = new ArrayList<>();

    public GalleryPageAdapter(Context mContext,int[] mImageIds) {
        this.mContext = mContext;
        this.mImageIds = mImageIds;
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(mImageIds[i]);
            viewlist.add(imageView);

            //设置图片的阴影
//            imageView.setImageBitmap(GetInverted.getReverseBitmapById(imageViewID[i],this));

        }
    }

    @Override
    public int getCount() {
//                return imageViewList == null ? 0 : imageViewList.size();
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//                ImageView imageView = imageViewList.get(position);
//        Log.i(tag,"------position-------"+position);
//        Log.i(tag,"------position%mImageIds.length-------"+position%mImageIds.length);
//        ImageView imageView = new ImageView(mContext);
//        imageView.setImageResource(mImageIds[position%mImageIds.length]);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
////                imageView.setBackgroundResource(mGalleryItemBackground);
//        container.addView(imageView, position);

        //对ViewPager页号求模取出View列表中要显示的项
        position %= viewlist.size();
        if (position<0){
            position = viewlist.size()+position;
        }
        final int pos = position;
        ImageView imageView = viewlist.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent vp =imageView.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(imageView);
        }
        container.addView(imageView);
        //add listeners here if necessary
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点了:"+pos,Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(temp);
    }
}
