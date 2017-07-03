package com.secondproject.main.service;

import java.util.List;

import com.secondproject.main.dao.MainDaoImpl;
import com.secondproject.main.model.MainExhibitionDto;

public class MainServiceImpl implements MainService {

	private static MainService mainService;

	static {
		mainService = new MainServiceImpl();
	}

	private MainServiceImpl() {
	}

	public static MainService getMainService() {
		return mainService;
	}

	@Override
	public List<MainExhibitionDto> listMainExhibition() {
		return MainDaoImpl.getMainDao().listMainExhibition();
	}

}
