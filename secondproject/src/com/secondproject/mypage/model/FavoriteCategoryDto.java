package com.secondproject.mypage.model;

public class FavoriteCategoryDto {
	private int favoriteCategoryId;
	private int userId;
	private int parentCategoryId;
	private String categoryName;
	private String categoryOrder;
	public int getFavoriteCategoryId() {
		return favoriteCategoryId;
	}
	public void setFavoriteCategoryId(int favoriteCategoryId) {
		this.favoriteCategoryId = favoriteCategoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryOrder() {
		return categoryOrder;
	}
	public void setCategoryOrder(String categoryOrder) {
		this.categoryOrder = categoryOrder;
	}
	
	

}
