package com.secondproject.admin.model;

public class OwnerDto {
	//ownerconfirm 테이블 dto가 필요하신분은 OwnerDto 사용하세요!!
	private int userId;
	private int shopId;
	private int confirmOk;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getConfirmOk() {
		return confirmOk;
	}
	public void setConfirmOk(int confirmOk) {
		this.confirmOk = confirmOk;
	}
}
