package com.joephone.codebox.act.classic.rangeseek.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dalong.rangeseekbar.RangeBar;
import com.joephone.codebox.R;
import com.joephone.codebox.act.classic.rangeseek.util.Component;
import com.joephone.codebox.act.classic.rangeseek.view.ColorPickerDialog;


public class NewRangeSeekBarAct extends AppCompatActivity{

    private static final int DEFAULT_BAR_COLOR = 0xffcccccc;
    private static final int DEFAULT_CONNECTING_LINE_COLOR = 0xff33b5e5;
    private static final int HOLO_BLUE = 0xff33b5e5;

    // 设置初始值，这样图像将被绘制
    private static final int DEFAULT_THUMB_COLOR_NORMAL = -1;
    private static final int DEFAULT_THUMB_COLOR_PRESSED = -1;

    // 设置变量以保存每个属性的颜色
    private int mBarColor = DEFAULT_BAR_COLOR;
    private int mConnectingLineColor = DEFAULT_CONNECTING_LINE_COLOR;
    private int mThumbColorNormal = DEFAULT_THUMB_COLOR_NORMAL;
    private int mThumbColorPressed = DEFAULT_THUMB_COLOR_PRESSED;

    private RangeBar rangebar;

    //在旋转屏幕/重新启动活动时保存状态
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("BAR_COLOR", mBarColor);
        bundle.putInt("CONNECTING_LINE_COLOR", mConnectingLineColor);
        bundle.putInt("THUMB_COLOR_NORMAL", mThumbColorNormal);
        bundle.putInt("THUMB_COLOR_PRESSED", mThumbColorPressed);
    }

    // 在旋转屏幕/重新启动活动时恢复状态
    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        mBarColor = bundle.getInt("BAR_COLOR");
        mConnectingLineColor = bundle.getInt("CONNECTING_LINE_COLOR");
        mThumbColorNormal = bundle.getInt("THUMB_COLOR_NORMAL");
        mThumbColorPressed = bundle.getInt("THUMB_COLOR_PRESSED");


        rangebar = (RangeBar) findViewById(R.id.rangebar1);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.range_seek_bar_new);

        //获取控件
        rangebar = (RangeBar) findViewById(R.id.rangebar1);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }






    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
