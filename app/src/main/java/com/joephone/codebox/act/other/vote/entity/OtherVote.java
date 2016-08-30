package com.joephone.codebox.act.other.vote.entity;

public class OtherVote {

	public String optionName; // 当前选项
	public int currentNUm; // 当前选项投票数
	public double optionPercent;// 当前投票选项百分比
	public static boolean ischecked = false; // 投票按钮是否点击
	public int image; // 选项中的图片

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getCurrentNUm() {
		return currentNUm;
	}

	public void setCurrentNUm(int currentNUm) {
		this.currentNUm = currentNUm;
	}

	public double getOptionPercent() {
		return optionPercent;
	}

	public void setOptionPercent(double optionPercent) {
		this.optionPercent = optionPercent;
	}

	public Boolean getIschecked() {
		return ischecked;
	}

	public void setIschecked(Boolean ischecked) {
		this.ischecked = ischecked;
	}

	public OtherVote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtherVote(String optionName, int currentNUm, double optionPercent,
			boolean ischecked, int image) {
		super();
		this.optionName = optionName;
		this.currentNUm = currentNUm;
		this.optionPercent = optionPercent;
		this.ischecked = ischecked;
		this.image = image;
	}

}
