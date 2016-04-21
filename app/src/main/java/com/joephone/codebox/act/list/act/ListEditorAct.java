package com.joephone.codebox.act.list.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.list.adapter.ListEditorAdapter;

/**
 * 复用问题
 */

public class ListEditorAct extends Activity implements OnClickListener {
	
	private Button selectAllBtn;
	private Button deselectAllBtn;
	private Button cancelSelectAll;
	
	private ListView lvEditor;
	private ListEditorAdapter adapter;

	private List<Map<String, String>> mData = new ArrayList<Map<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_editor);
		
		selectAllBtn = (Button) findViewById(R.id.btn_selectAll);
		selectAllBtn.setOnClickListener(this);
		deselectAllBtn = (Button) findViewById(R.id.btn_cancleselectall);
		deselectAllBtn.setOnClickListener(this);
		cancelSelectAll = (Button) findViewById(R.id.btn_cancelAll);
		cancelSelectAll.setOnClickListener(this);
		
		lvEditor = (ListView) findViewById(R.id.lvEditor);
		adapter = new ListEditorAdapter(this);
		lvEditor.setAdapter(adapter);
		for(int i = 0; i < 20; i++) {
			Map<String, String> item = new HashMap<String, String>();
			item.put("list_item_inputvalue", i+"");
			mData.add(item);
		}
		adapter.setData(mData);
		
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				// 取得ViewHolder对象，这样就省去了通过层层的findViewById去实例化我们需要的cb实例的步骤
//				ViewHolder holder = (ViewHolder) view.getTag();
//				// 改变CheckBox的状态
//				holder.checkBox.toggle();
//				// 将CheckBox的选中状况记录下来
//				mAdapter.getIsSelected().put(position,holder.checkBox.isChecked());
//				// 调整选定条目
//				if(holder.checkBox.isChecked() == true) {
//					checkNum++;
//				} else {
//					checkNum--;
//				}	
//			}
//		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_selectAll:
			for (int i = 0; i < mData.size(); i++) {
				adapter.getIsSelected().put(i, true);
			}
			adapter.notifyDataSetChanged();
			break;
		case R.id.btn_cancleselectall:
			// 遍历list的长度，将已选的设为未选，未选的设为已选
			for (int i = 0; i < mData.size(); i++) {
				if (adapter.getIsSelected().get(i)) {
					adapter.getIsSelected().put(i, false);
				} else {
					adapter.getIsSelected().put(i, true);
				}
			}
			adapter.notifyDataSetChanged();
			break;
		case R.id.btn_cancelAll:
			for (int i = 0; i < mData.size(); i++) {
				if (adapter.getIsSelected().get(i)) {
					adapter.getIsSelected().put(i, false);
				}
			}
			adapter.notifyDataSetChanged();
			break;
		}
	}

}