package com.joephone.codebox.act.list.entity;

public class ListChildItem {
	private String vegetable_name;
	private int vegetable_num;
	private double vegetable_cost;

	public String getVegetable_name() {
		return vegetable_name;
	}

	public void setVegetable_name(String vegetable_name) {
		this.vegetable_name = vegetable_name;
	}

	public int getVegetable_num() {
		return vegetable_num;
	}

	public void setVegetable_num(int vegetable_num) {
		this.vegetable_num = vegetable_num;
	}

	public double getVegetable_cost() {
		return vegetable_cost;
	}

	public void setVegetable_cost(float vegetable_cost) {
		this.vegetable_cost = vegetable_cost;
	}

	public ListChildItem(String vegetable_name) {
		this.vegetable_name = vegetable_name;
	}

	public ListChildItem() {
	}
	
	
	
}
