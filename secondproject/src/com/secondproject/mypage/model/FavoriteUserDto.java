package com.secondproject.mypage.model;

public class FavoriteUserDto {
	private int favoriteUserId;
	private int userId;
	private	int favoriteCategoryId;
	private int regUserId;
	private String comment;
	private String favoriteRegDate;
	private String alias;
	public int getFavoriteUserId() {
		return favoriteUserId;
	}
	public void setFavoriteUserId(int favoriteUserId) {
		this.favoriteUserId = favoriteUserId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFavoriteCategoryId() {
		return favoriteCategoryId;
	}
	public void setFavoriteCategoryId(int favoriteCategoryId) {
		this.favoriteCategoryId = favoriteCategoryId;
	}
	public int getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(int regUserId) {
		this.regUserId = regUserId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFavoriteRegDate() {
		return favoriteRegDate;
	}
	public void setFavoriteRegDate(String favoriteRegDate) {
		this.favoriteRegDate = favoriteRegDate;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
}
