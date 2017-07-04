package com.secondproject.map.model;

import java.util.ArrayList;

public class FollowCategoryDto {
	private int followCategoryId;
	private int userId;
	private String categoryName;
	private int categoryOrder;
	private ArrayList<FollowCategoryUserDto> categoryUserList;

	public int getFollowCategoryId() {
		return followCategoryId;
	}

	public void setFollowCategoryId(int followCategoryId) {
		this.followCategoryId = followCategoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(int categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public ArrayList<FollowCategoryUserDto> getCategoryUserList() {
		return categoryUserList;
	}

	public void setCategoryUserList(ArrayList<FollowCategoryUserDto> categoryUserList) {
		this.categoryUserList = categoryUserList;
	}

}
