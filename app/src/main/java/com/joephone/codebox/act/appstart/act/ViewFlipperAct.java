package com.joephone.codebox.act.appstart.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.joephone.codebox.R;
import com.joephone.codebox.act.appstart.utils.AppStartAnimUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewFlipperAct extends Activity implements OnGestureListener {

    @Bind(R.id.tvInNew)
    TextView tvInNew;
    @Bind(R.id.vf_activity)
    ViewFlipper vfActivity;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appstart_viewflipper);
        ButterKnife.bind(this);

        initView();
    }

    @SuppressWarnings("deprecation")
    private void initView() {
        mGestureDetector = new GestureDetector(this);
        tvInNew.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(ViewFlipperAct.this, SuccessLaunchActivity.class));
                AppStartAnimUtil.finishActivityAnimation(ViewFlipperAct.this);
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        if (e1.getX() > e2.getX()) {
            vfActivity.showNext();
        } else if (e1.getX() < e2.getX()) {
            vfActivity.showPrevious();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @OnClick(R.id.tvInNew)
    public void onClick() {
    }
}
