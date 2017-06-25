package com.secondproject.mypage.model;

public class MyReviewDto {

	private String shopName;
	private String address;
	private String shopScore;
	private String Email;
	private String myScore;
	private String subject;
	private String content;
	private String update_date;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShopScore() {
		return shopScore;
	}
	public void setShopScore(String shopScore) {
		this.shopScore = shopScore;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMyScore() {
		return myScore;
	}
	public void setMyScore(String myScore) {
		this.myScore = myScore;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}
