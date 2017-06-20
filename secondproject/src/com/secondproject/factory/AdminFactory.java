package com.secondproject.factory;

import com.secondproject.admin.action.*;

public class AdminFactory {

	private static ExhibitionWriteAction exhibitionWriteAction;


	private static ExhibitionListAction exhibitionListAction;
	
	private static ExhibitionViewAction exhibitionViewAction;

	public static ExhibitionViewAction getExhibitionViewAction() {
		return exhibitionViewAction;
	}

	static {
		exhibitionWriteAction = new ExhibitionWriteAction();
		exhibitionListAction = new ExhibitionListAction();
		exhibitionViewAction = new ExhibitionViewAction();
	}
	
	public static ExhibitionListAction getExhibitionListAction() {
		return exhibitionListAction;
	}
	
	public static ExhibitionWriteAction getExhibitionWriteAction() {
		return exhibitionWriteAction;
	}
	
}
