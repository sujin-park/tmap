package com.secondproject.shop.model;

public class ShopDto extends ShopCategoryDto{
	private int shopId;
	private int categoryId;
	private String title;
	private Double lat;
	private Double lng;
	private Double score;
	private int ownerId;
	private String reserveUrl;
	private String address;
	private String tel;
	private String businessTime;
	private String detail;
	private String img;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getReserveUrl() {
		return reserveUrl;
	}

	public void setReserveUrl(String reserveUrl) {
		this.reserveUrl = reserveUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
