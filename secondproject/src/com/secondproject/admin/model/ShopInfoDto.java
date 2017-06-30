package com.secondproject.admin.model;

public class ShopInfoDto {
	private String categoryName;
	private String shopTitle;
	private String shopTel;
	private String shopAddress;
	private int exhibitionId;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public int getExhibitionId() {
		return exhibitionId;
	}
	public void setExhibitionId(int exhibitionId) {
		this.exhibitionId = exhibitionId;
	}
}
