package com.joephone.codebox.act.classic.act;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.joephone.codebox.R;
import com.joephone.codebox.act.classic.view.SanPopupWindow;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SanMainActivity extends BaseActivity implements OnClickListener {


    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.tvRight)
    TextView tvRight;

    private SanPopupWindow popupWindow;
    private String str ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.san_main);
        ButterKnife.bind(this);

        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("Area");
    }


    @OnClick({R.id.back, R.id.tvRight})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tvRight:
                popupWindow = new SanPopupWindow(SanMainActivity.this,okOnClick,str);
                popupWindow.showAtLocation(v, Gravity.BOTTOM
                        | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
        }
    }


    // 弹出窗按钮点击事件
    OnClickListener okOnClick = new OnClickListener() {
        public void onClick(View v) {
//            Toast.makeText(this, "当前选中:"+mCurrentProviceName+","+mCurrentCityName+","
//                    +mCurrentDistrictName+","+mCurrentZipCode, Toast.LENGTH_SHORT).show();
//            popupWindow.getmViewProvince().get
            Toast.makeText(SanMainActivity.this,popupWindow.getStr(),Toast.LENGTH_SHORT).show();    //"当前选中"
        }
    };
}

