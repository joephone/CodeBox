package com.joephone.codebox.act.pic.gallary3d.act;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.pic.gallary3d.adapter.GalleryPageAdapter;
import com.joephone.codebox.act.pic.gallary3d.util.MyTaransformation;


public class Gallery3dAct extends Activity {
    private String tag = this.getClass().getName();
    private ViewPager viewPager;
    private int pagerWidth;
    private int[] mImageIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_gallary_3d);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageView i1 = new ImageView(this);
        i1.setImageResource(R.drawable.found_rank_wealth);
        ImageView i2 = new ImageView(this);
        i2.setImageResource(R.drawable.found_rank_pop);
        ImageView i3 = new ImageView(this);
        i3.setImageResource(R.drawable.found_rank_skill);
        ImageView i4 = new ImageView(this);
        i4.setImageResource(R.drawable.found_rank_fishingplace);
        ImageView i5 = new ImageView(this);
        i5.setImageResource(R.drawable.found_rank_record_score);


        mImageIds = new int[]{
                R.drawable.found_rank_wealth,
                R.drawable.found_rank_pop,
                R.drawable.found_rank_skill,
                R.drawable.found_rank_fishingplace,
                R.drawable.found_rank_record_score};


        viewPager.setOffscreenPageLimit(3);

        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0 / 5.0f);
        ViewGroup.LayoutParams lp = viewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);

        } else {
            lp.width = pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);


        findViewById(R.id.pic_gallary_3d).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return viewPager.dispatchTouchEvent(event);
            }
        });

        viewPager.setPageTransformer(true, new MyTaransformation());

        viewPager.setAdapter(new GalleryPageAdapter(Gallery3dAct.this,mImageIds));
    }
}
