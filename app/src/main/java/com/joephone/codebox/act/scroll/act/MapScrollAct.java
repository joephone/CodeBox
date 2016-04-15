package com.joephone.codebox.act.scroll.act;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.joephone.codebox.R;
import com.joephone.codebox.act.scroll.view.MapScrollView;
import com.joephone.codebox.act.scroll.view.MapScrollView.OnScrollListener;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MapScrollAct extends Activity implements OnScrollListener {

    @Bind(R.id.rlayout)
    RelativeLayout rlayout;
    @Bind(R.id.etSearch)
    EditText etSearch;
    @Bind(R.id.search02)
    LinearLayout search02;
    @Bind(R.id.myScrollView)
    MapScrollView myScrollView;
    @Bind(R.id.ivTitle)
    ImageView ivTitle;
    @Bind(R.id.search01)
    LinearLayout search01;
    @Bind(R.id.ivMap)
    ImageView ivMap;


    private int searchLayoutTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_map_float);
        ButterKnife.bind(this);
        //初始化控件
        init();
    }

    private void init() {

        myScrollView.setOnScrollListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Log.i("personal", "rlayout:" + rlayout.getBottom());
            Log.i("personal", "ivTitle:" + ivTitle.getBottom());
            searchLayoutTop = rlayout.getBottom() - 120;//获取searchLayout的顶部位置
        }
    }

    //监听滚动Y值变化，通过addView和removeView来实现悬停效果
    @Override
    public void onScroll(int scrollY) {
        Log.i("personal", "scrollY:" + scrollY);
        Log.i("personal", "searchLayoutTop:" + searchLayoutTop);

        if (scrollY >= searchLayoutTop) {
            if (etSearch.getParent() != search01) {
                search02.removeView(etSearch);
                search01.addView(etSearch);
            }
        } else {
            if (etSearch.getParent() != search02) {
                search01.removeView(etSearch);
                search02.addView(etSearch);
            }
        }
    }
}
