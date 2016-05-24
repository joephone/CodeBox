package com.joephone.codebox.act.appstart.act.scrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.appstart.act.SuccessLaunchActivity;
import com.joephone.codebox.act.appstart.utils.AppStartAnimUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScollerViewAct extends Activity implements
        OnScrollChangedListener {

    @Bind(R.id.ll_anim)
    LinearLayout llAnim;
    @Bind(R.id.tvInNew)
    TextView tvInNew;
    @Bind(R.id.sv_main)
    MyScrollView svMain;
    private int mScrollViewHeight;
    private int mStartAnimateTop;
    private boolean hasStart = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appstart_scrollview);
        ButterKnife.bind(this);


        initView();
        setView();
    }

    private void initView() {
        tvInNew.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(ScollerViewAct.this, SuccessLaunchActivity.class));
                AppStartAnimUtil.finishActivityAnimation(ScollerViewAct.this);
            }
        });
    }

    private void setView() {
        svMain.setOnScrollChangedListener(this);
        llAnim.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mScrollViewHeight = svMain.getHeight();
        mStartAnimateTop = mScrollViewHeight / 5 * 4;
    }

    @Override
    public void onScrollChanged(int top, int oldTop) {
        int animTop = llAnim.getTop() - top;
        if (top > oldTop) {
            if (animTop < mStartAnimateTop && !hasStart) {
                Animation anim = AnimationUtils
                        .loadAnimation(this, R.anim.show);
                llAnim.setVisibility(View.VISIBLE);
                llAnim.startAnimation(anim);
                hasStart = true;
            }
        } else {
            if (animTop > mStartAnimateTop && hasStart) {
                Animation anim = AnimationUtils.loadAnimation(this,
                        R.anim.close);
                llAnim.setVisibility(View.INVISIBLE);
                llAnim.startAnimation(anim);
                hasStart = false;
            }
        }
    }

}
