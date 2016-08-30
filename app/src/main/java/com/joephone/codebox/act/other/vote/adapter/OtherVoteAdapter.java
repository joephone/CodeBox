package com.joephone.codebox.act.other.vote.adapter;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.other.vote.act.OtherVoteActivity;
import com.joephone.codebox.act.other.vote.entity.OtherVote;

public class OtherVoteAdapter extends BaseAdapter {

	public static boolean isclick = false;
	public static int lastPosition = -1;
	Context context;
	List<OtherVote> listItems;
	HashMap<String, Boolean> states = new HashMap<String, Boolean>(); // 用于记录每个RadioButton的状态，并保证只可选一个

	public class ViewHolder {
		public TextView checked_num, checked_precnet;
		public ProgressBar progressBar;
		public RadioButton rb_toupiao;
	}

	public OtherVoteAdapter(Context context, List<OtherVote> listItems) {
		this.context = context;
		this.listItems = listItems;
	}

	@Override
	public int getCount() {
		return listItems.size();
	}

	@Override
	public Object getItem(int position) {
		return listItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint({ "InflateParams", "ViewHolder" })
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewholder = new ViewHolder();
		convertView = LayoutInflater.from(context).inflate(
				R.layout.other_vote_item, null);
		viewholder.checked_precnet = (TextView) convertView
				.findViewById(R.id.checked_bilv);
		viewholder.checked_num = (TextView) convertView
				.findViewById(R.id.checked_num);

		final RadioButton radio = (RadioButton) convertView.findViewById(R.id.rb_toupiao);
		viewholder.rb_toupiao = radio;

		viewholder.progressBar = (ProgressBar) convertView
				.findViewById(R.id.progressBar);

		int sum = 0;
		for (int i = 0; i < listItems.size(); i++) {
			sum = listItems.get(i).getCurrentNUm() + sum;
		}
		int a = listItems.get(position).getCurrentNUm();

		if (radio.isChecked()) {
			radio.setFocusable(false);
		}
		viewholder.checked_num.setText((listItems.get(position).currentNUm)
				+ "");
		viewholder.rb_toupiao.setText(listItems.get(position).getOptionName()
				+ "");

		// 单选按钮
		// 当RadioButton被选中时，将其状态记录进States中，并更新其他RadioButton的状态使它们不被选中
		viewholder.rb_toupiao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				OtherVoteAdapter.isclick = true;
				for (String key : states.keySet()) {
					states.put(key, false);
				}
				
				if (lastPosition == -1) { //判断是否第一次进入
					listItems.get(position).currentNUm++;
					lastPosition = position;
				} else {
					if (lastPosition != position) {
						listItems.get(position).currentNUm++;
						listItems.get(lastPosition).currentNUm--;
						lastPosition = position;
					}
				}

				states.put(String.valueOf(position), radio.isChecked());
				OtherVoteAdapter.this.notifyDataSetChanged();
			}
		});
		boolean res = false;
		if (states.get(String.valueOf(position)) == null
				|| states.get(String.valueOf(position)) == false) {
			res = false;
			states.put(String.valueOf(position), false);
		} else {
			res = true;
		}
		viewholder.rb_toupiao.setChecked(res);
		
		if (OtherVoteActivity.ischeck == true) {
			radio.setClickable(false);
			OtherVoteActivity.ischeck = false;
		}
		
		// 
		double precent = (double) ((a + 0.0) / sum);
		NumberFormat nt = NumberFormat.getPercentInstance();
		nt.setMinimumFractionDigits(2);
		viewholder.progressBar.setMax(sum); //设置最大进度值
		
		viewholder.progressBar.setProgress(a);
		viewholder.checked_precnet.setText("(" + nt.format(precent) + ")");// 百分比

		return convertView;
	}

}
