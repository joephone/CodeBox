package com.joephone.codebox.act.pic.gallary3d.act;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import com.joephone.codebox.R;
import com.joephone.codebox.act.pic.gallary3d.widget.GalleryFlow;
import com.joephone.codebox.act.pic.gallary3d.widget.ImageAdapter;


public class GalleryFlowAct extends Activity {
    /** Called when the activity is first created. */
    private GalleryFlow galleryFlow;
    private ImageAdapter adapter;
    private GestureDetector detector;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_nsouth_jonas);

        detector = new GestureDetector(new MyGestureListener());
        int[] images = {
                R.drawable.found_rank_wealth,
                R.drawable.found_rank_pop,
                R.drawable.found_rank_skill,
                R.drawable.found_rank_fishingplace,
                R.drawable.found_rank_record_score };
        adapter = new ImageAdapter(this, images);
        adapter.createReflectedImages();   //创建倒影效果

        galleryFlow = (GalleryFlow) findViewById(R.id.gallery);
        galleryFlow.setAdapter(adapter);
        galleryFlow.setSelection(1);
    }

    private class MyGestureListener extends SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            // TODO Auto-generated method stub
            int currentPosition = galleryFlow.getSelectedItemPosition();
            if (e1.getX() - e2.getX() > 50 && Math.abs(velocityX) > 100) {
                if (currentPosition + 1 == adapter.getCount()) {
                    galleryFlow.setSelection(0);
                } else {
                    galleryFlow.setSelection(currentPosition + 1);
                }
            } else if (e2.getX() - e1.getX() > 50 && Math.abs(velocityX) > 100) {
                if (currentPosition - 1 < 0) {
                    galleryFlow.setSelection(adapter.getCount() - 1);
                } else {
                    galleryFlow.setSelection(currentPosition - 1);
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        return detector.onTouchEvent(event);
    }


}