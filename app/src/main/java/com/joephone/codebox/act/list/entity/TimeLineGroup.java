package com.joephone.codebox.act.list.entity;

import java.util.List;

/**
 * 一级Item实体类
 * 
 * @author zihao
 * 
 */
public class TimeLineGroup {
	private String groupName;
	/** 二级Item数据列表 **/
	private List<TimeLineChild> childList;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<TimeLineChild> getChildList() {
		return childList;
	}

	public void setChildList(List<TimeLineChild> childList) {
		this.childList = childList;
	}

}