package com.joephone.codebox.act.classic.weibo.act;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.classic.weibo.view.MoreWindow;

public class WeiboPlusAct extends Activity {

	ImageView image;
	MoreWindow mMoreWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weibo_plus);

		image = (ImageView) findViewById(R.id.show);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showMoreWindow(v);
			}
		});
	}

	private void showMoreWindow(View view) {
		if (null == mMoreWindow) {
			mMoreWindow = new MoreWindow(this);
			mMoreWindow.init();
		}

		mMoreWindow.showMoreWindow(view,100);
	}


}
