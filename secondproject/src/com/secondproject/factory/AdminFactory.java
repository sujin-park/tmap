package com.secondproject.factory;

import com.secondproject.admin.action.ExhibitionListAction;
import com.secondproject.admin.action.ExhibitionWriteAction;

public class AdminFactory {

	private static ExhibitionWriteAction exhibitionWriteAction;


	private static ExhibitionListAction exhibitionListAction;
	

	static {
		exhibitionWriteAction = new ExhibitionWriteAction();
		exhibitionListAction = new ExhibitionListAction();
	}
	
	public static ExhibitionListAction getExhibitionListAction() {
		return exhibitionListAction;
	}
	
	public static ExhibitionWriteAction getExhibitionWriteAction() {
		return exhibitionWriteAction;
	}
	
}
