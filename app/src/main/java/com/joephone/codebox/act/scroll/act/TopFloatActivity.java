package com.joephone.codebox.act.scroll.act;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.joephone.codebox.R;
import com.joephone.codebox.act.scroll.view.TopFloatMeiTuanScrollView;
import com.joephone.codebox.act.scroll.view.TopFloatMeiTuanScrollView.OnScrollListener;


public class TopFloatActivity extends Activity implements OnScrollListener{
	private EditText etSearch;
	private ImageView ivTitle;
	private TopFloatMeiTuanScrollView myScrollView;
    private int searchLayoutTop;
    
    LinearLayout search01,search02;
    RelativeLayout rlayout;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll_top_float_meituan);
		//初始化控件
		init();
	}

	private void init() {
		ivTitle = (ImageView)findViewById(R.id.ivTitle);
		etSearch = (EditText)findViewById(R.id.etSearch);
		myScrollView = (TopFloatMeiTuanScrollView)findViewById(R.id.myScrollView);
		search01 = (LinearLayout)findViewById(R.id.search01);
		search02 = (LinearLayout)findViewById(R.id.search02);
		rlayout = (RelativeLayout)findViewById(R.id.rlayout);
		myScrollView.setOnScrollListener(this);  
        
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);    
        if(hasFocus){  
        	Log.i("personal", "rlayout:"+rlayout.getBottom());
        	Log.i("personal", "ivTitle:"+ivTitle.getBottom());
        	searchLayoutTop = rlayout.getBottom()-120;//获取searchLayout的顶部位置
        }
	}

	//监听滚动Y值变化，通过addView和removeView来实现悬停效果
	@Override
	public void onScroll(int scrollY) {
		Log.i("personal", "scrollY:"+scrollY);
    	Log.i("personal", "searchLayoutTop:"+searchLayoutTop);
		
		if(scrollY >= searchLayoutTop){  
			if (etSearch.getParent()!=search01) {
				search02.removeView(etSearch);
				search01.addView(etSearch);
			}
        }else{
        	if (etSearch.getParent()!=search02) {
        		search01.removeView(etSearch);
        		search02.addView(etSearch);
			}
        }
	}
}
