package com.joephone.codebox.act.classic.act;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.classic.san.CityPicker;
import com.joephone.codebox.act.classic.view.AreaPopupWindow;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CPAct extends Activity {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.tvRight)
    TextView tvRight;
//    @Bind(R.id.citypicker)
//    CityPicker citypicker;

    private AreaPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_picker_main);
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
                popupWindow = new AreaPopupWindow(CPAct.this);
                popupWindow.showAtLocation(v, Gravity.BOTTOM
                        | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
        }
    }
}
