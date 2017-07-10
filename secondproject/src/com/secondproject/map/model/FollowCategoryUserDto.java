package com.secondproject.map.model;

public class FollowCategoryUserDto {
	private int followUserId;
	private int userId;
	private String userEmail;
	private int followCategoryId;
	private int regUserId;
	private String alias;
	private String memo;
	private String regDate;
	private int mapReviewCount;

	public int getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(int followUserId) {
		this.followUserId = followUserId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getFollowCategoryId() {
		return followCategoryId;
	}

	public void setFollowCategoryId(int followCategoryId) {
		this.followCategoryId = followCategoryId;
	}

	public int getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(int regUserId) {
		this.regUserId = regUserId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getMapReviewCount() {
		return mapReviewCount;
	}

	public void setMapReviewCount(int mapReviewCount) {
		this.mapReviewCount = mapReviewCount;
	}

}
