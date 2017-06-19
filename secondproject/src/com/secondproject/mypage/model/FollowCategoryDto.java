package com.secondproject.mypage.model;

public class FollowCategoryDto {
	private int followCategoryId;
	private int userId;
	private String categoryName;
	private int categoryOrder;
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
	
	

}
