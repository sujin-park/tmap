package com.secondproject.admin.service;

import java.util.List;

import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;

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
	public List<ExhibitionDto> listExhibition() {
		return ExhibitionDaoImpl.getExhibitionDao().listExhibition();
	};

}
