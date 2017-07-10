package com.secondproject.mypage.model;

public class FollowUserDto {
	private int favoriteUserId;
	private int userId;
	private	int favoriteCategoryId;
	private int regUserId;
	private String memo;
	private String favoriteRegDate;
	private String alias;
	private String categoryName;
	private String email;
	private String statusMsg;
	private String regDate;
	private String followId;
	private String followCount;
	private String follower;
	private String followerCount;
	
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId = followId;
	}
	public String getFollowCount() {
		return followCount;
	}
	public void setFollowCount(String followCount) {
		this.followCount = followCount;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(String followerCount) {
		this.followerCount = followerCount;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
