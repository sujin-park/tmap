package com.secondproject.admin.model;

public class ExhibitionDto{
	private int exhibitionId;
	private String exTitle;
	private String exDesc;
	private String exImage;
	private int exOrder;
	private int exVisiable;
	public int getExhibitionId() {
		return exhibitionId;
	}
	public void setExhibitionId(int exhibitionId) {
		this.exhibitionId = exhibitionId;
	}
	public String getExTitle() {
		return exTitle;
	}
	public void setExTitle(String exTitle) {
		this.exTitle = exTitle;
	}
	public String getExDesc() {
		return exDesc;
	}
	public void setExDesc(String exDesc) {
		this.exDesc = exDesc;
	}
	public String getExImage() {
		return exImage;
	}
	public void setExImage(String exImage) {
		this.exImage = exImage;
	}
	public int getExOrder() {
		return exOrder;
	}
	public void setExOrder(int exOrder) {
		this.exOrder = exOrder;
	}
	public int getExVisiable() {
		return exVisiable;
	}
	public void setExVisiable(int exVisiable) {
		this.exVisiable = exVisiable;
	}
}
