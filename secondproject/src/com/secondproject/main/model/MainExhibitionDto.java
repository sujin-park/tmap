package com.secondproject.main.model;

public class MainExhibitionDto {
	
	// 기획전 기본 정보
	private int exhibitionId;
	private String ex_title;
	private String ex_desc;
	private String ex_image;
	private int ex_order;
	private int ex_visiable;
	// 매장 정보들
	private int exd_order;
	private String shop_name; // 매장명
	private String exd_desc; // 기획전에서 쓴 매장 코멘트
	private String address; // 매장 주소
	private int score; // 매장 점수
	
}
