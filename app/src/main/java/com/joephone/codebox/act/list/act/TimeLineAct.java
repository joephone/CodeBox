package com.joephone.codebox.act.list.act;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

import com.joephone.codebox.R;
import com.joephone.codebox.act.list.adapter.TimeLineAdapter;
import com.joephone.codebox.act.list.entity.TimeLineChild;
import com.joephone.codebox.act.list.entity.TimeLineGroup;


public class TimeLineAct extends Activity {

	private ExpandableListView expandlistView;
	private TimeLineAdapter adapter;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_timeline);
		context = this;
		expandlistView = (ExpandableListView) findViewById(R.id.expandlist);
		initExpandListView();
	}

	/**
	 * 初始化可拓展列表
	 */
	private void initExpandListView() {
		adapter = new TimeLineAdapter(context, getListData());
		expandlistView.setAdapter(adapter);
		expandlistView.setGroupIndicator(null); // 去掉默认带的箭头
		expandlistView.setSelection(0);// 设置默认选中项

		// 遍历所有group,将所有项设置成默认展开
		int groupCount = expandlistView.getCount();
		for (int i = 0; i < groupCount; i++) {
			expandlistView.expandGroup(i);
		}

		expandlistView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// TODO Auto-generated method stub
				return true;
			}
		});
	}

	private List<TimeLineGroup> getListData() {
		List<TimeLineGroup> groupList;
		String[] strArray = new String[] { "10月22日", "10月23日","10月25日","10月16日","10月10日" };
		String[][] childTimeArray = new String[][] {
				{ "俯卧撑十次", "仰卧起坐二十次", "大喊我爱紫豪二十次", "每日赞紫豪一次" },
				{ "亲，快快滴点赞哦~" }, { "没有赞的，赶紧去赞哦~" }, { "来来来，齐白石" },
				{ "来来来，张大千", "张大千" } };
		groupList = new ArrayList<TimeLineGroup>();
		for (int i = 0; i < strArray.length; i++) {
			TimeLineGroup groupStatusEntity = new TimeLineGroup();
			groupStatusEntity.setGroupName(strArray[i]);

			List<TimeLineChild> childList = new ArrayList<TimeLineChild>();

			for (int j = 0; j < childTimeArray[i].length; j++) {
				TimeLineChild childStatusEntity = new TimeLineChild();
				childStatusEntity.setCompleteTime(childTimeArray[i][j]);
				childStatusEntity.setIsfinished(true);
				childList.add(childStatusEntity);
			}

			groupStatusEntity.setChildList(childList);
			groupList.add(groupStatusEntity);
		}
		return groupList;
	}
}