package com.joephone.codebox.act.pic.act;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

import com.joephone.codebox.R;
import com.joephone.codebox.act.pic.util.PicDragImageBitmapUtil;
import com.joephone.codebox.act.pic.view.PicDragImageView;
import com.joephone.codebox.util.DensityUtils;

public class DragImageActivity extends Activity {
	private int window_width, window_height;// 控件宽度
	private PicDragImageView ivDrag;// 自定义控件
	private int state_height;// 状态栏的高度

	private ViewTreeObserver viewTreeObserver;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pic_dragimage);
		/** 获取可見区域高度 **/
		window_width = DensityUtils.getScreenW(this);
		window_height = DensityUtils.getScreenH(this);

		ivDrag = (PicDragImageView) findViewById(R.id.ivDrag);
		Bitmap bmp = PicDragImageBitmapUtil.ReadBitmapById(this, R.drawable.beauty01,          //pic_dragimage_huoying
				window_width, window_height);
		// 设置图片
		ivDrag.setImageBitmap(bmp);
		ivDrag.setmActivity(this);//注入Activity.
		/** 测量状态栏高度 **/
		viewTreeObserver = ivDrag.getViewTreeObserver();
		viewTreeObserver
				.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

					@Override
					public void onGlobalLayout() {
						if (state_height == 0) {
							// 获取状况栏高度
							Rect frame = new Rect();
							getWindow().getDecorView()
									.getWindowVisibleDisplayFrame(frame);
							state_height = frame.top;
							ivDrag.setScreen_H(window_height-state_height);
							ivDrag.setScreen_W(window_width);
						}

					}
				});

	}

	/**
	 * 读取本地资源的图片
	 * 
	 * @param context
	 * @param resId
	 * @return
	 */
	public static Bitmap ReadBitmapById(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// 获取资源图片
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}

}