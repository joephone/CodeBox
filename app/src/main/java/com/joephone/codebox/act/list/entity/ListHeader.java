package com.joephone.codebox.act.list.entity;

import java.util.ArrayList;
import java.util.List;

public class ListHeader {
	private String tagName;
	// Item列表, 不含标题
	private List<ListChildItem> itemList = new ArrayList<ListChildItem>();

	public ListHeader(String tagName) {
		// 设置标题
		this.tagName = tagName;
	}

	public String getmCategoryName() {
		return tagName;
	}

	public void addItemList(ListChildItem pItemName) {
		itemList.add(pItemName);
	}

	/**
	 * 获取Item内容
	 * 
	 * @param position
	 * @return
	 */
	public Object getItem(int position) {
		// 标题排在第一位
		if (position == 0) {
			return tagName;
		} else {
			return itemList.get(position - 1);
		}
	}
	
	/**
     * 当前类别Item总数。标题也需要占用一个Item
     * @return 
     */
	public int getItemCount() {
       return itemList.size() + 1;
   }
}
