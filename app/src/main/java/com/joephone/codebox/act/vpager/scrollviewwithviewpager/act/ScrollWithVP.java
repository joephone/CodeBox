package com.joephone.codebox.act.vpager.scrollviewwithviewpager.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.joephone.codebox.R;

public class ScrollWithVP extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swp);
        
        findViewById(R.id.problemBtn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ScrollWithVP.this, ProblemActivity.class);
				startActivity(intent);
			}
		});
        
        findViewById(R.id.solution1Btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ScrollWithVP.this, Solution1Activity.class);
				startActivity(intent);
			}
		});
        
        findViewById(R.id.solution2Btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ScrollWithVP.this, Solution2Activity.class);
				startActivity(intent);
			}
		});
        
        findViewById(R.id.solution3Btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ScrollWithVP.this, Solution3Activity.class);
				startActivity(intent);
			}
		});
    }
}
