package com.secondproject.mypage.service;

import java.util.List;

import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.mypage.model.FollowCategoryDto;

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
	public List<FollowCategoryDto> followCategoryListView(int userId) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryListView(userId);
	}

	@Override
	public int upOrder(int favoriteCategoryId) {
		return MypageFollowDaoImpl.getMypageFollowDao().upOrder(favoriteCategoryId);
	}

	@Override
	public int downOrder(int favoriteCategoryId) {
		// TODO Auto-generated method stub
		return MypageFollowDaoImpl.getMypageFollowDao().downOrder(favoriteCategoryId);
	}

}
