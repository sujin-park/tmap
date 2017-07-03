package com.secondproject.admin.service;

import java.util.*;

import com.secondproject.admin.action.ExhibitionShopUpAction;
import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.constant.BoardConstant;
import com.secondproject.shop.model.ShopDto;

public class ExhibitionServiceImpl implements ExhibitionService {

	private ExhibitionServiceImpl(){}
	
	private static ExhibitionService exhibitionService;
	
	public static ExhibitionService getExhibitionService() {
		return exhibitionService;
	}
	static {
		exhibitionService = new ExhibitionServiceImpl();
	}
	@Override
	public int writeExhibition(ExhibitionDto exhibitionDto) {
		return ExhibitionDaoImpl.getExhibitionDao().writeExhibition(exhibitionDto);
	}
	@Override
	public List<ExhibitionDto> listExhibition(Map<String, Object> params) {
		return ExhibitionDaoImpl.getExhibitionDao().listExhibition(params);
		
	}
	@Override
	public ExhibitionDto viewExhibition(int seq) {
		return ExhibitionDaoImpl.getExhibitionDao().viewExhibition(seq);
	}
	@Override
	public List<ShopDto> shopExhibition(Map<String, Object> params) {
		return ExhibitionDaoImpl.getExhibitionDao().shopExhibition(params);
	}
	@Override
	public int deleteExhibition(String[] exhibitions) {
		return ExhibitionDaoImpl.getExhibitionDao().deleteExhibition(exhibitions);
	}
	@Override
	public int plusExhibition(String[] shops, int seq) {
		return ExhibitionDaoImpl.getExhibitionDao().plusExhibition(shops, seq);
	}
	@Override
	public int modifyExhibition(ExhibitionDto exhibitionDto) {
		return ExhibitionDaoImpl.getExhibitionDao().modifyExhibition(exhibitionDto);
	}
	@Override
	public List<ShopDto> shopUpdated(int seq) {
		return ExhibitionDaoImpl.getExhibitionDao().shopUpdated(seq);
	}
	@Override
	public int deleteShopList(int exseq, int shopseq) {
		return ExhibitionDaoImpl.getExhibitionDao().deleteShopList(exseq, shopseq);
	};

}
