package com.secondproject.factory;

import com.secondproject.admin.action.*;

public class AdminFactory {

	private static ExhibitionWriteAction exhibitionWriteAction;
	private static ExhibitionListAction exhibitionListAction;
	private static ExhibitionViewAction exhibitionViewAction;
	private static ExhibitionShopAction exhibitionShopAction;
	private static ExhibitionDeleteAction exhibitionDeleteAction;
	private static ExhibitionShopUpAction exhibitionShopUpAction;
	private static ExhibitionModifyAction exhibitionModifyAction;

	static {
		exhibitionWriteAction = new ExhibitionWriteAction();
		exhibitionListAction = new ExhibitionListAction();
		exhibitionViewAction = new ExhibitionViewAction();
		exhibitionShopAction = new ExhibitionShopAction();
		exhibitionDeleteAction = new ExhibitionDeleteAction();
		exhibitionShopUpAction = new ExhibitionShopUpAction();
		exhibitionModifyAction = new ExhibitionModifyAction();
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
}
