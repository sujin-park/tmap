package com.secondproject.admin.model;

public class OwnerConfirmDto {
	//이건사장관리를 위한 dto. ownerconfirm 테이블 dto가 필요하신분은 OwnerDto 사용하세요!!
	private String userEmail;
	private String userRegDate;
	private String shopTitle;
	private String shopTel;
	private String shopAddress;
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}
	public String getShopTitle() {
		return shopTitle;
	}
	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}
	public String getShopTel() {
		return shopTel;
	}
	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}


}
