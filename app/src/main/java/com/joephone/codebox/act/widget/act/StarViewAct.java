package com.joephone.codebox.act.widget.act;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.joephone.codebox.R;
import com.joephone.codebox.act.widget.view.Star;

import butterknife.Bind;
import butterknife.ButterKnife;


public class StarViewAct extends Activity implements Star.OnStarChangeListener{
    private String tag = this.getClass().getName();

    @Bind(R.id.star)
    Star star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.star_view);
        ButterKnife.bind(this);
        //    mPv.setFilters(new InputFilter[]{new PhoneFilter()});
        /**

         *设置显示几颗星

         * 5.0f代表五颗星，4.2代表四颗星加上第五颗星得五分之一

         */

        star.setMark(2.0f);
        star.getMark();



    }


    /**

     *设置控件监听

     */
    @Override
    public void onStarChange(Float mark) {
        Log.i(tag,"---mark---"+mark);
    }
}
