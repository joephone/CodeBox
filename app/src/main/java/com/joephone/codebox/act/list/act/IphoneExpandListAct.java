package com.joephone.codebox.act.list.act;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.joephone.codebox.R;

public class IphoneExpandListAct extends Activity implements
		OnScrollListener {

	private static final String TAG = "iphone";
	private static final String PRE = "IphoneExpandableListActivity--";

	private ExpandableListView listView;
	private MyExpandableListAdapter mAdapter;

	private FrameLayout indicatorGroup;
	private int indicatorGroupId = -1;
	private int indicatorGroupHeight;

	private LayoutInflater mInflater;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.iphone_expand_main);
		mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		listView = (ExpandableListView) findViewById(R.id.expandableListView);
		indicatorGroup = (FrameLayout) findViewById(R.id.topGroup);
		// indicatorGroup.setVisibility(View.INVISIBLE);

		mAdapter = new MyExpandableListAdapter();
		listView.setAdapter(mAdapter);
		listView.setOnScrollListener(this);
		listView.setGroupIndicator(null);
		// copy group view to indicator Group
		mInflater.inflate(R.layout.iphone_expand_list_item, indicatorGroup, true);
	}

	/**
	 * A simple adapter which maintains an ArrayList of photo resource Ids. Each
	 * photo is displayed as an image. This adapter supports clearing the list
	 * of photos and adding a new photo.
	 * 
	 */
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {
		// Sample data set. children[i] contains the children (String[]) for
		// groups[i].
		private String[] groups = { "People Names", "Dog Names", "Cat Names",
				"Fish Names" };
		private String[][] children = {
				{ "Way", "Arnold", "Barry", "Chuck", "David", "Afghanistan",
						"Albania", "Belgium", "Lily", "Jim", "LiMing", "Jodan" },
				{ "Ace", "Bandit", "Cha-Cha", "Deuce", "Bahamas", "China",
						"Dominica", "Jim", "LiMing", "Jodan" },
				{ "Fluffy", "Snuggles", "Ecuador", "Ecuador", "Jim", "LiMing",
						"Jodan" },
				{ "Goldy", "Bubbles", "Iceland", "Iran", "Italy", "Jim",
						"LiMing", "Jodan" } };

		public Object getChild(int groupPosition, int childPosition) {
			return children[groupPosition][childPosition];
		}

		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		public int getChildrenCount(int groupPosition) {
			return children[groupPosition].length;
		}

		public TextView getGenericView() {
			// Layout parameters for the ExpandableListView
			AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 64);

			TextView textView = new TextView(IphoneExpandListAct.this);
			textView.setLayoutParams(lp);
			// Center the text vertically
			textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			// Set the text starting position
			textView.setPadding(36, 0, 0, 0);
			textView.setTextColor(Color.BLACK);
			return textView;
		}

		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			TextView textView = getGenericView();
			textView.setText(getChild(groupPosition, childPosition).toString());
			return textView;
		}

		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		public int getGroupCount() {
			return groups.length;
		}

		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		/**
		 * create group view and bind data to view
		 */
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			View v;
			if (convertView == null) {
				v = mInflater.inflate(R.layout.iphone_expand_list_item, null);
			} else {
				v = convertView;
			}
			TextView textView = (TextView) v.findViewById(R.id.textView);

			textView.setText(getGroup(groupPosition).toString());
			return v;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

		public boolean hasStableIds() {
			return true;
		}

	}

	/**
	 * here is very importance for indicator group
	 */
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {

		final ExpandableListView listView = (ExpandableListView) view;
		/**
		 * calculate point (0,0)
		 */
		int npos = view.pointToPosition(0, 0);// 其实就是firstVisibleItem
		if (npos == AdapterView.INVALID_POSITION)// 如果第一个位置值无效
			return;

		long pos = listView.getExpandableListPosition(npos);
		int childPos = ExpandableListView.getPackedPositionChild(pos);// 获取第一行child的id
		int groupPos = ExpandableListView.getPackedPositionGroup(pos);// 获取第一行group的id
		if (childPos == AdapterView.INVALID_POSITION) {// 第一行不是显示child,就是group,此时没必要显示指示器
			View groupView = listView.getChildAt(npos
					- listView.getFirstVisiblePosition());// 第一行的view
			indicatorGroupHeight = groupView.getHeight();// 获取group的高度
			indicatorGroup.setVisibility(View.GONE);// 隐藏指示器
		} else{
			indicatorGroup.setVisibility(View.VISIBLE);// 滚动到第一行是child，就显示指示器
		}
		// get an error data, so return now
		if (indicatorGroupHeight == 0) {
			return;
		}
		// update the data of indicator group view
		if (groupPos != indicatorGroupId) {// 如果指示器显示的不是当前group
			mAdapter.getGroupView(groupPos, listView.isGroupExpanded(groupPos),
					indicatorGroup.getChildAt(0), null);// 将指示器更新为当前group
			indicatorGroupId = groupPos;
			Log.e(TAG, PRE + "bind to new group,group position = " + groupPos);
			// mAdapter.hideGroup(indicatorGroupId); // we set this group view
			// to be hided
			// 为此指示器增加点击事件
			indicatorGroup.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					listView.collapseGroup(indicatorGroupId);
				}
			});
		}
		if (indicatorGroupId == -1) // 如果此时grop的id无效，则返回
			return;

		/**
		 * calculate point (0,indicatorGroupHeight) 下面是形成往上推出的效果
		 */
		int showHeight = indicatorGroupHeight;
		int nEndPos = listView.pointToPosition(0, indicatorGroupHeight);// 第二个item的位置
		if (nEndPos == AdapterView.INVALID_POSITION)//如果无效直接返回
			return;
		long pos2 = listView.getExpandableListPosition(nEndPos);
		int groupPos2 = ExpandableListView.getPackedPositionGroup(pos2);//获取第二个group的id
		if (groupPos2 != indicatorGroupId) {//如果不等于指示器当前的group
			View viewNext = listView.getChildAt(nEndPos
					- listView.getFirstVisiblePosition());
			showHeight = viewNext.getTop();
			Log.e(TAG, PRE + "update the show part height of indicator group:"
					+ showHeight);
		}

		// update group position
		MarginLayoutParams layoutParams = (MarginLayoutParams) indicatorGroup
				.getLayoutParams();
		layoutParams.topMargin = -(indicatorGroupHeight - showHeight);
		indicatorGroup.setLayoutParams(layoutParams);
	}

	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}
}