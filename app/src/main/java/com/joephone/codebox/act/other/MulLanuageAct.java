package com.joephone.codebox.act.other;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.joephone.codebox.R;

public class MulLanuageAct extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.multi_language);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mul_lan, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Configuration config = getResources().getConfiguration();
		switch (item.getItemId()) {
		case R.id.action_english:
			config.locale = Locale.ENGLISH;
			break;
		case R.id.action_simple_chinses:
			config.locale = Locale.SIMPLIFIED_CHINESE;
			break;
		case R.id.action_traditional_chinese:
			config.locale = Locale.TRADITIONAL_CHINESE;
			break;
		default:
			return true;
		}
		getResources().updateConfiguration(config, getResources().getDisplayMetrics());
		((TextView)findViewById(R.id.textViewHello)).setText(R.string.hello_world);;
		return true;
	}


}
