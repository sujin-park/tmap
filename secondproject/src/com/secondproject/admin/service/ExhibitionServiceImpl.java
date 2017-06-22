package com.secondproject.admin.service;

import java.util.*;

import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
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
	public int writeExhibition(ExhibitionDetailDto exhibitionDetailDto) {
		return ExhibitionDaoImpl.getExhibitionDao().writeExhibition(exhibitionDetailDto);
	}
	@Override
	public List<ExhibitionDto> listExhibition(String key, String word, String order, String column) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("order", order);
		map.put("column", column);
		
		return ExhibitionDaoImpl.getExhibitionDao().listExhibition(map);
		
	}
	@Override
	public ExhibitionDetailDto viewExhibition(int seq) {
		return ExhibitionDaoImpl.getExhibitionDao().viewExhibition(seq);
	}
	@Override
	public List<ShopDto> shopExhibition() {
		return ExhibitionDaoImpl.getExhibitionDao().shopExhibition();
	}
	@Override
	public int deleteExhibition(int seq) {
		return ExhibitionDaoImpl.getExhibitionDao().deleteExhibition(seq);
	};

}
