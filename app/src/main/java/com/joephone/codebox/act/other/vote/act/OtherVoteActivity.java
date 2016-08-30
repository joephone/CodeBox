package com.joephone.codebox.act.other.vote.act;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.joephone.codebox.R;
import com.joephone.codebox.act.other.vote.adapter.OtherVoteAdapter;
import com.joephone.codebox.act.other.vote.entity.OtherVote;

public class OtherVoteActivity extends Activity implements OnClickListener {

	public static boolean ischeck = false;
	private Button poll_btn;
	private List<OtherVote> listItems;
	private OtherVoteAdapter adapter;
	private ListView myListView;
	private TextView image_poll;
	private ImageView ivGoToGroupLevel;
	String[] optionName = { "美人01", "美人02", "美人03", "美人04" };
	String[] currentNUm = { "39", "60", "101", "0" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.other_vote);

		image_poll = (TextView) findViewById(R.id.image_poll);
		image_poll.setOnClickListener(this);

		poll_btn = (Button) findViewById(R.id.poll_btn);
		poll_btn.setOnClickListener(this);
		ivGoToGroupLevel = (ImageView) findViewById(R.id.ivGoToGroupLevel);
		ivGoToGroupLevel.setOnClickListener(this);

		listItems = getData();
		myListView = (ListView) findViewById(R.id.mylistview);
		myListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		adapter = new OtherVoteAdapter(this, listItems);
		myListView.setAdapter(adapter);
		
	}

	private List<OtherVote> getData() {
		List<OtherVote> list = new ArrayList<OtherVote>();
		for (int i = 0; i < optionName.length; i++) {
			OtherVote poll = new OtherVote();
			poll.optionName = optionName[i];
			poll.currentNUm = Integer.parseInt(currentNUm[i]);
			list.add(poll);
		}
		return list;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_poll:
			Intent intent = new Intent(this, OtherVoteBeautyActivity.class);
			startActivity(intent);
			break;
		case R.id.ivGoToGroupLevel:
			intent = new Intent(this, OtherVoteGroupLevelActivity.class);
			startActivity(intent);
			break;
			
		case R.id.poll_btn:
			if (OtherVoteAdapter.isclick == true) {
				ischeck = true;
				adapter.notifyDataSetChanged();
				poll_btn.setClickable(false);
			}else {
				Toast.makeText(this, "请选择一个选项", Toast.LENGTH_SHORT).show();
			}
			
			break;
		default:
			break;
		}
	}

}
