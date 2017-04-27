package com.joephone.codebox.act.widget.act;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.widget.view.PhoneView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PhoneViewAct extends Activity {


    @Bind(R.id.pv)
    PhoneView pv;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.bt)
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_view);
        ButterKnife.bind(this);
        //    mPv.setFilters(new InputFilter[]{new PhoneFilter()});

        pv.setTextListener(new PhoneView.OnPhoneChangeListener() {
            @Override
            public void onChange(String s) {
                tv.setText(s);
            }
        });

    }


}
