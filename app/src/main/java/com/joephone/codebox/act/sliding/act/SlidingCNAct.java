package com.joephone.codebox.act.sliding.act;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.chenjishi.slideupdemo.SlidingUpPaneLayout;
import com.joephone.codebox.R;

public class SlidingCNAct extends Activity {
    private String tag ="SlidingCNAct";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_cn);

        final float density = getResources().getDisplayMetrics().density;

        Log.i(tag,"density"+density);

        SlidingUpPaneLayout slidingUpPaneLayout = (SlidingUpPaneLayout) findViewById(R.id.sliding_up_layout);
        slidingUpPaneLayout.setParallaxDistance((int) (200 * density));
//        slidingUpPaneLayout.setShadowResourceTop(R.drawable.shadow_top);

        /**
         * limit scroll zone to 32dp, if you want whole view can scroll
         * just ignore this method, don't call it
         */
//        slidingUpPaneLayout.setEdgeSize((int) (density * 32));

        slidingUpPaneLayout.openPane();

    }
}
