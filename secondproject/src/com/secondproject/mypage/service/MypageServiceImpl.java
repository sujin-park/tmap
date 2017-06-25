package com.secondproject.mypage.service;

import java.util.List;

import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;

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
	public int upOrder(int followCategoryId) {
		return MypageFollowDaoImpl.getMypageFollowDao().upOrder(followCategoryId);
	}

	@Override
	public int downOrder(int followCategoryId) {
		// TODO Auto-generated method stub
		return MypageFollowDaoImpl.getMypageFollowDao().downOrder(followCategoryId);
	}

	@Override
	public int followCategoryMake(FollowCategoryDto followCategoryDto) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryMake(followCategoryDto);
	}

	@Override
	public List<FollowUserDto> followListView(int userId) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followListView(userId);
	}

	@Override
	public int followdelete(int followUserId) {
		return MypageFollowDaoImpl.getMypageFollowDao().followdelete(followUserId);
	}

	@Override
	public int followCategoryDelete(int followCategoryId) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryDelete(followCategoryId);
	}

}
