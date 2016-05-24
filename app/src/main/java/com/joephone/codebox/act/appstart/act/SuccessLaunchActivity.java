/**
 * SuccessLaunchActivity.java [V 1..0.0]
 * classes : com.zhangyx.MyLauncherGuide.SuccessLaunchActivity
 * zhangyx Create at 2015-1-21 下午1:58:49
 */
package com.joephone.codebox.act.appstart.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.joephone.codebox.R;
import com.joephone.codebox.act.appstart.utils.AppStartAnimUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


//import com.lidroid.xutils.ViewUtils;
//import com.lidroid.xutils.view.annotation.ViewInject;
//import com.zhangyx.MyLauncherGuide.utils.AnimationUtil;

/**
 * 引导成功界面
 * com.zhangyx.MyLauncherGuide.SuccessLaunchActivity
 *
 * @author Admin-zhangyx
 *         <p>
 *         create at 2015-1-21 下午1:58:49
 */
public class SuccessLaunchActivity extends Activity {


    @Bind(R.id.btnBack)
    Button btnBack;

    /* (non-Javadoc)
         * @see android.app.Activity#onCreate(android.os.Bundle)
         */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appstart_successlaunch);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnBack)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                startActivity(new Intent(SuccessLaunchActivity.this, MyLauncherGuideAct.class));
                AppStartAnimUtil.finishActivityAnimation(SuccessLaunchActivity.this);
                break;
        }

    }
}
