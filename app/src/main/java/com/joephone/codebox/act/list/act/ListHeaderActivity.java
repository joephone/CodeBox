package com.joephone.codebox.act.list.act;

import java.util.ArrayList;
import java.util.List;


import com.joephone.codebox.R;
import com.joephone.codebox.act.list.adapter.ListHeaderAdapter;
import com.joephone.codebox.act.list.entity.ListChildItem;
import com.joephone.codebox.act.list.entity.ListHeader;
import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ListView;

public class ListHeaderActivity extends Activity {
	private String tag = "ListHeaderActivity";
	private ListView listView;
	private ListHeaderAdapter adapter;
	// 类别集合
	private List<ListHeader> sourceList = new ArrayList<ListHeader>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_header);

		ListHeader m1 = new ListHeader("中国 江苏");
		ListHeader m2 = new ListHeader("中国 浙江");
		ListHeader m3 = new ListHeader("阿联酋 迪拜");
		List<ListChildItem> itemList = new ArrayList<ListChildItem>();
		ListChildItem item = new ListChildItem("明孝陵");
		ListChildItem item2 = new ListChildItem("中山陵");
		// itemList.add(item);
		// itemList.add(item2);
		m1.addItemList(item);
		m1.addItemList(item2);

		m2.addItemList(item);
		m2.addItemList(item2);

		m3.addItemList(item);
		m3.addItemList(item2);

		sourceList.add(m1);
		sourceList.add(m2);
		sourceList.add(m3);

		listView = (ListView) findViewById(R.id.listView);
		adapter = new ListHeaderAdapter(ListHeaderActivity.this, sourceList);
		listView.setAdapter(adapter);


	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getResources().getDisplayMetrics());
	}
}
