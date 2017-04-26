package com.joephone.codebox.act.pic.gallaryswitcher.act;

 
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

import com.joephone.codebox.R;

public class GallarySwitcherAct extends Activity implements OnItemSelectedListener,
		ViewFactory {
	@SuppressWarnings("deprecation")
	private Gallery gallery;
	private ImageSwitcher imageSwitcher;
	//存放要显示的图片的ID的整型数组
	private int[] resId = { R.drawable.beauty01, R.drawable.beauty02,
			R.drawable.beauty03, R.drawable.beauty04 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pic_gallary_switcher);
		gallery = (Gallery) findViewById(R.id.gallery);
		ImageAdapter imageAdapter = new ImageAdapter(GallarySwitcherAct.this);
		gallery.setAdapter(imageAdapter);
		gallery.setOnItemSelectedListener(this);
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
		imageSwitcher.setFactory(this);
	}
	/**
	 * 图片数据的适配器，主要实现的函数是getView函数，该函数返回每个每个图片对象。
	 * @author CTH
	 *
	 */
	class ImageAdapter extends BaseAdapter {
		private Context context;
		public ImageAdapter(Context context) {
			this.context = context;
		}
		@Override
		public int getCount() {
			return resId.length;
		}
		@Override
		public Object getItem(int position) {
			return resId[position];
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = null;
			if(convertView != null) {
				imageView = (ImageView) convertView;
			} else{
				imageView = new ImageView(context);
				imageView.setImageResource(resId[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(300, 150));
			}
			return imageView;
		}
	}
	/**
	 * Gallery被点击执行的函数。
	 */
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,long id) {
		imageSwitcher.setImageResource(resId[position]);
	}
	/**
	 * Gallery未被点击执行的函数。
	 */
	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
	/**
	 * 实现ViewFactory接口函数。当ImageSwitcher被调用时，会回调该函数以获取ImageSwitcher显示的View。
	 */
	@Override
	public View makeView() {
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundColor(0x1B0ED8);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		return imageView;
	}
}

