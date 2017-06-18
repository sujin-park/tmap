package com.secondproject.mypage.service;

import java.util.List;

import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.mypage.model.FavoriteCategoryDto;

public class MypageServiceImpl implements MypageService {

	private static MypageService mypageService;
	static {
		mypageService = new MypageServiceImpl();
	}
	
	public static MypageService getMypageService() {
		return mypageService;
	}

	private MypageServiceImpl() {}
	
	@Override
	public List<FavoriteCategoryDto> followCategoryListView(int userId) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryListView(userId);
	}

}
