package com.joephone.codebox.act.scroll.scrollVPFloatLayout.act;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.joephone.codebox.R;
import com.joephone.codebox.act.scroll.view.ExtendScrollView;
import com.joephone.codebox.act.scroll.view.TopFloatMeiTuanScrollView;
import com.joephone.codebox.act.vpager.scrollviewwithviewpager.act.Content2Fragment;
import com.joephone.codebox.act.vpager.scrollviewwithviewpager.act.Content3Fragment;
import com.joephone.codebox.act.vpager.scrollviewwithviewpager.act.ContentFragmentOne;
import com.joephone.codebox.act.vpager.scrollviewwithviewpager.adapter.ViewPagerFragmentAdapter;

public class ScrollVPFloatLayoutAct extends FragmentActivity implements TopFloatMeiTuanScrollView.TopFloatMeiTuanScrollListener{
	private EditText etSearch;
	private ImageView ivTitle;
	private TopFloatMeiTuanScrollView myScrollView;
	private int searchLayoutTop;

	LinearLayout search01,search02,vpTitleGrp;
	RelativeLayout rlayout,titleGrp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll_vp_float_layout);

		init();


		// 模拟网络请求完成之后重置ViewPager高度
	}


	private void init() {
		titleGrp = (RelativeLayout)findViewById(R.id.titleGrp);
//		etSearch = (EditText)findViewById(R.id.etSearch);
		myScrollView = (TopFloatMeiTuanScrollView)findViewById(R.id.myScrollView);
		search01 = (LinearLayout)findViewById(R.id.search01);
		search02 = (LinearLayout)findViewById(R.id.search02);
		vpTitleGrp = (LinearLayout)findViewById(R.id.vpTitleGrp);
		rlayout = (RelativeLayout)findViewById(R.id.rlayout);
		myScrollView.setOnScrollListener(this);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus){
			Log.i("personal", "rlayout:"+rlayout.getBottom());
			Log.i("personal", "titleGrp:"+titleGrp.getBottom());
			searchLayoutTop = rlayout.getHeight()-titleGrp.getHeight();//获取searchLayout的顶部位置
		}
	}

	//监听滚动Y值变化，通过addView和removeView来实现悬停效果
	@Override
	public void onScroll(int scrollY) {
		Log.i("personal", "scrollY:"+scrollY);
		Log.i("personal", "searchLayoutTop:"+searchLayoutTop);

		if(scrollY >= searchLayoutTop){
			if (vpTitleGrp.getParent()!=search01) {
				search02.removeView(vpTitleGrp);
				search01.addView(vpTitleGrp);
			}
		}else{
			if (vpTitleGrp.getParent()!=search02) {
				search01.removeView(vpTitleGrp);
				search02.addView(vpTitleGrp);
			}
		}
	}

}
