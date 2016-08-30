package com.joephone.codebox.act.other.vote.act;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.joephone.codebox.R;

public class OtherVoteGroupLevelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.other_vote_group_level);
	}
}
