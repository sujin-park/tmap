package com.secondproject.admin.model;

public class ExhibitionDetailDto extends ExhibitionDto{

	private int shopId;
	private int exdOrder;
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getExdOrder() {
		return exdOrder;
	}
	public void setExdOrder(int exdOrder) {
		this.exdOrder = exdOrder;
	}
	public String getExdDesc() {
		return exdDesc;
	}
	public void setExdDesc(String exdDesc) {
		this.exdDesc = exdDesc;
	}
	private String exdDesc;
}
