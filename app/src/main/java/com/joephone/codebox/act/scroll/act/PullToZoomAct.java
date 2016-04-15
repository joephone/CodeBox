package com.joephone.codebox.act.scroll.act;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.joephone.codebox.R;

public class PullToZoomAct extends Activity {
	private String tag = this.getClass().getName();
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll_pulltozoom);

	}
}
