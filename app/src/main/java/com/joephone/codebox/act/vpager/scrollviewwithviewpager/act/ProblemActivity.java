package com.joephone.codebox.act.vpager.scrollviewwithviewpager.act;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.joephone.codebox.R;
import com.joephone.codebox.act.vpager.scrollviewwithviewpager.adapter.ViewPagerFragmentAdapter;

public class ProblemActivity extends FragmentActivity {
	private ViewPager viewPager;
	
	private ViewPagerFragmentAdapter adapter;
	private MyListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swp_problem);
		
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
//		adapter.addFragment(new ContentFragmentOne());
		adapter.addFragment(new Content2Fragment());
		adapter.addFragment(new Content3Fragment());
		viewPager.setOnPageChangeListener(listener);
		viewPager.setAdapter(adapter);
		
	}
	
	public class MyListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			
		}

		@Override
		public void onPageSelected(int position) {
			switch (position) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			}
		}
	}
}
