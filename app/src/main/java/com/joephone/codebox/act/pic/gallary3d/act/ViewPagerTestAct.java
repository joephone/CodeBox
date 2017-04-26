package com.joephone.codebox.act.pic.gallary3d.act;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.pic.gallary3d.util.ImageUtil;
import com.joephone.codebox.act.pic.gallary3d.util.MyLogger;
import com.joephone.codebox.act.pic.gallary3d.view.RotateDownPageTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ViewPagerTestAct extends Activity{

    private List<ImageView> imageViewList;
    private List<Integer> mImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_gallary_3d);
        final ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);

        initImage();
        initImageView();
        viewPager.setOffscreenPageLimit(3);
        int pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if (lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width= pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);
        findViewById(R.id.pic_gallary_3d).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
        viewPager.setPageTransformer(true,new RotateDownPageTransformer(viewPager));
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViewList.get(position));
                MyLogger.d("PagerAdapter");
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView=imageViewList.get(position);
                container.addView(imageView,position);
                return imageView;
            }
        });
    }

    private void initImage() {
        mImageList = new ArrayList<>();
        mImageList.add(R.drawable.beauty01);
        mImageList.add(R.drawable.beauty02);
        mImageList.add(R.drawable.beauty03);
        mImageList.add(R.drawable.beauty04);
        mImageList.add(R.drawable.beauty05);
        mImageList.add(R.drawable.beauty06);
    }

    private void initImageView() {
        imageViewList=new ArrayList<>();
        for (int i = 0; i < mImageList.size(); i++) {
            ImageView imageView = new ImageView(ViewPagerTestAct.this);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            Bitmap bitmap = ImageUtil.readBitMap(this, mImageList.get(i));
            Bitmap bitmap = ImageUtil.getReverseBitmapById(mImageList.get(i), this);
            imageView.setImageBitmap(bitmap);
            imageViewList.add(imageView);
            MyLogger.d("test","MyLogger");
        }
    }
}
