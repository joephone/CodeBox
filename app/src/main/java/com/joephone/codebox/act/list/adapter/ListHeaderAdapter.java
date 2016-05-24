package com.joephone.codebox.act.list.adapter;

import java.util.ArrayList;
import java.util.List;

import com.joephone.codebox.R;
import com.joephone.codebox.act.list.entity.ListChildItem;
import com.joephone.codebox.act.list.entity.ListHeader;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListHeaderAdapter extends BaseAdapter {
	private Context context;

	// 标题类型
	private static final int TYPE_CATEGORY_ITEM = 0;
	// 子项类型
	private static final int TYPE_ITEM = 1;
	// 类别集合
	private List<ListHeader> sourceList = new ArrayList<ListHeader>();
	// 布局填充器
	private LayoutInflater mInflater;

	public ListHeaderAdapter(Context context, List<ListHeader> sourceList) {
		mInflater = LayoutInflater.from(context);
		this.sourceList = sourceList;
	}

	/**
	 * 获取所有分类的Item的总数
	 */
	@Override
	public int getCount() {
		int count = 0;
		if (null != sourceList) {
			// 所有分类中item的总和是ListVIew Item的总个数
			for (ListHeader category : sourceList) {
				count += category.getItemCount();
			}
		}
		return count;
	}

	/**
	 * 获取Item
	 */
	@Override
	public Object getItem(int position) {
		// 异常情况处理
		if (null == sourceList || position < 0 || position > getCount()) {
			return null;
		}
		// 同一分类内，第一个元素的索引值
		int categroyFirstIndex = 0;
		for (ListHeader category : sourceList) {
			int size = category.getItemCount();
			// 在当前分类中的索引值
			int categoryIndex = position - categroyFirstIndex;
			// item在当前分类内
			if (categoryIndex < size) {
				return category.getItem(categoryIndex);
			}
			// 索引移动到当前分类结尾，即下一个分类第一个元素索引
			categroyFirstIndex += size;
		}
		return null;
	}

	/**
	 * 获取Item的类别，也即确定是子项还是标题项
	 */
	@Override
	public int getItemViewType(int position) {
		// 异常情况处理
		if (null == sourceList || position < 0 || position > getCount()) {
			return TYPE_ITEM;
		}
		// 初始遍历位置
		int categroyFirstIndex = 0;
		// 遍历实体类集合
		for (ListHeader category : sourceList) {
			int size = category.getItemCount();
			// 在当前分类中的索引值
			int categoryIndex = position - categroyFirstIndex;
			// 如果是首项返回标题类型
			if (categoryIndex == 0) {
				return TYPE_CATEGORY_ITEM;
			}
			// 如果是子项返回子项类型
			if (categoryIndex > 0
					&& categoryIndex < category.getItemCount() - 1) {
				return TYPE_ITEM;
			}
			categroyFirstIndex += size;
		}
		return TYPE_ITEM;
	}

	// 返回标题的数目, 该方法不能删除，标题数目根据自己程序的需要返回不同的值，这里我的例子中只有两个标题
	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取指定位置的Item的类型
		int itemViewType = getItemViewType(position);
		switch (itemViewType) {
		// 如果是标题类型, 则填充标题布局
		case TYPE_CATEGORY_ITEM:
			
			if (null == convertView) {
				convertView = mInflater.inflate(R.layout.map_list_group_item,
						null);
			}
			TextView textView = (TextView) convertView
					.findViewById(R.id.tvTagName);
			LinearLayout layoutTag = (LinearLayout) convertView
					.findViewById(R.id.layoutTag); 
			String itemValue = (String) getItem(position);
			textView.setText(itemValue);
			layoutTag.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			}); 
			break;
		// 如果是子项类型则填充子项的布局
		case TYPE_ITEM:
			ViewHolder holder = null;
			if (null == convertView) {
				convertView = mInflater
						.inflate(R.layout.map_list_children_item, null);
				holder = new ViewHolder();
				holder.vegeName = (TextView) convertView
						.findViewById(R.id.tvChildName);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.vegeName.setText(((ListChildItem) getItem(position)).getVegetable_name());
			break;
		}
		
		
		return convertView;
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		return getItemViewType(position) != TYPE_CATEGORY_ITEM;
	}

	private class ViewHolder {
		TextView vegeName;
		ImageView arrow_right;
	}
	
	

}
