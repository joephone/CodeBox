package com.joephone.codebox.act.other.vote.act;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.joephone.codebox.R;
import com.joephone.codebox.act.other.vote.adapter.OtherVoteBeautyAdapter;
import com.joephone.codebox.act.other.vote.entity.OtherVote;
import com.joephone.codebox.act.other.vote.view.OtherVoteGridView;

public class OtherVoteBeautyActivity extends Activity {

	private Button pollButton;
	private OtherVoteGridView mGridView = null;
	private OtherVoteBeautyAdapter adapter;
	private List<OtherVote> listItems;
//	private String[] optionName = { "图一", "图二", "图三", "图四", "图五", "图六", "图七",
//			"图八", "图九" };
	private String[] optionName = { "图一", "图二", "图三", "图四"};
//	private int[] image = { R.drawable.zero, R.drawable.one, R.drawable.two,
//			R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six,
//			R.drawable.seven, R.drawable.eight };
	private String[] currentNUm = {"333","21","90","45"};
	private int[] image = { R.drawable.beauty01, R.drawable.beauty02, R.drawable.beauty03,
			R.drawable.beauty04};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.other_vote_beauty);

		if (OtherVoteBeautyAdapter.back == true) {
			OtherVote.ischecked = false;
		}
		
		initview();
		mGridView = (OtherVoteGridView) findViewById(R.id.my_gridView);
		listItems = getData();
		adapter = new OtherVoteBeautyAdapter(this, listItems);
		mGridView.setAdapter(adapter);
	}

	private void initview() {
		// TODO Auto-generated method stub
		pollButton = (Button) findViewById(R.id.poll_btn);
		pollButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OtherVote.ischecked = true;
				adapter.notifyDataSetChanged();
				pollButton.setFocusable(false);
			}
		});
		
		if (OtherVote.ischecked == true) {
			adapter.notifyDataSetChanged();
			pollButton.setFocusable(false);
		}
	}

	private List<OtherVote> getData() {
		List<OtherVote> list = new ArrayList<OtherVote>();
		for (int i = 0; i < optionName.length; i++) {
			OtherVote poll = new OtherVote();
			poll.optionName = optionName[i];
			poll.image = image[i];
			poll.currentNUm = Integer.parseInt(currentNUm[i]);
			list.add(poll);
		}
		return list;

	}
}
