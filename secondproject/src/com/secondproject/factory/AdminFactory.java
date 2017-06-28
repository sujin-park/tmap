package com.secondproject.factory;

import com.secondproject.admin.action.*;
import com.secondproject.admin.review.action.*;

public class AdminFactory {

	private static ExhibitionWriteAction exhibitionWriteAction;
	private static ExhibitionListAction exhibitionListAction;
	private static ExhibitionViewAction exhibitionViewAction;
	private static ExhibitionShopAction exhibitionShopAction;
	private static ExhibitionDeleteAction exhibitionDeleteAction;
	private static ExhibitionShopUpAction exhibitionShopUpAction;
	private static ExhibitionModifyAction exhibitionModifyAction;
	private static ExhibitionDeleteShopAction exhibitionDeleteShopAction;



	
	private static ReviewListAction reviewListAction;
	private static ReviewViewAction reviewViewAction;
	private static ReviewBlindAction reviewBlindAction;
	
	private static UserViewAction userViewAction;
	private static UserDeleteAction userDeleteAction;
	
	static {
		exhibitionWriteAction = new ExhibitionWriteAction();
		exhibitionListAction = new ExhibitionListAction();
		exhibitionViewAction = new ExhibitionViewAction();
		exhibitionShopAction = new ExhibitionShopAction();
		exhibitionDeleteAction = new ExhibitionDeleteAction();
		exhibitionShopUpAction = new ExhibitionShopUpAction();
		exhibitionModifyAction = new ExhibitionModifyAction();
		exhibitionDeleteShopAction = new ExhibitionDeleteShopAction();
		
		
		reviewListAction = new ReviewListAction();
		reviewViewAction = new ReviewViewAction();
		reviewBlindAction = new ReviewBlindAction();
		
		userViewAction = new UserViewAction();
		userDeleteAction = new UserDeleteAction();
	}


	public static ExhibitionDeleteShopAction getExhibitionDeleteShopAction() {
		return exhibitionDeleteShopAction;
	}

	public static ExhibitionListAction getExhibitionListAction() {
		return exhibitionListAction;
	}
	
	public static ExhibitionWriteAction getExhibitionWriteAction() {
		return exhibitionWriteAction;
	}
	
	public static ExhibitionViewAction getExhibitionViewAction() {
		return exhibitionViewAction;
	}
	
	public static ExhibitionShopUpAction getExhibitionShopUpAction() {
		return exhibitionShopUpAction;
	}

	public static ExhibitionDeleteAction getExhibitionDeleteAction() {
		return exhibitionDeleteAction;
	}

	public static ExhibitionShopAction getExhibitionShopAction() {
		return exhibitionShopAction;
	}
	
	public static ExhibitionModifyAction getExhibitionModifyAction() {
		return exhibitionModifyAction;
	}
	
	public static ReviewListAction getReviewListAction() {
		return reviewListAction;
	}
	
	public static ReviewViewAction getReviewViewAction() {
		return reviewViewAction;
	}

	public static ReviewBlindAction getReviewBlindAction() {
		return reviewBlindAction;
	}

	public static UserViewAction getUserViewAction() {
		return userViewAction;
	}
	
	public static UserDeleteAction getUserDeleteAction() {
		return userDeleteAction;
	}
}
