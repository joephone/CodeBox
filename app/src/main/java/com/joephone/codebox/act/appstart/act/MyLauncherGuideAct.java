package com.joephone.codebox.act.appstart.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.joephone.codebox.R;
import com.joephone.codebox.act.appstart.act.viewPage.ViewPagerActivity;
import com.joephone.codebox.act.appstart.utils.AppStartAnimUtil;
import com.joephone.codebox.act.appstart.act.scrollView.ScollerViewAct;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * APP 引导方式分类
 * com.zhangyx.MyLauncherGuide.MainActivity
 *
 * @author Admin-zhangyx
 *         <p/>
 *         create at 2015-1-21 下午2:04:27
 */
public class MyLauncherGuideAct extends Activity implements OnClickListener {


    @Bind(R.id.btnSplash)
    Button btnSplash;
    @Bind(R.id.btnViewPage)
    Button btnViewPage;
    @Bind(R.id.btnViewFlipper)
    Button btnViewFlipper;
    @Bind(R.id.btnScrollView)
    Button btnScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appstart_guide);
        ButterKnife.bind(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @OnClick({R.id.btnSplash, R.id.btnViewPage, R.id.btnViewFlipper, R.id.btnScrollView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSplash:
                startActivity(new Intent(this, AppStartSplashAct.class));
                break;
            case R.id.btnViewPage:
                startActivity(new Intent(this, ViewPagerActivity.class));
                break;
            case R.id.btnViewFlipper:
                startActivity(new Intent(this, ViewFlipperAct.class));
                break;
            case R.id.btnScrollView:
                startActivity(new Intent(this, ScollerViewAct.class));
                break;
        }
        AppStartAnimUtil.activityZoomAnimation(this);
    }
}
