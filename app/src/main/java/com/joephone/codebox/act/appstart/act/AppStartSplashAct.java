package com.joephone.codebox.act.appstart.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.joephone.codebox.act.appstart.utils.AppStartAnimUtil;
import com.joephone.codebox.R;


public class AppStartSplashAct extends Activity {

	private static final long DELAY_TIME = 3000L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appstart_splash);
		redirectByTime();
	}

	private void redirectByTime() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(AppStartSplashAct.this,SuccessLaunchActivity.class));
				AppStartAnimUtil.finishActivityAnimation(AppStartSplashAct.this);
			}
		}, DELAY_TIME);
	}
}
