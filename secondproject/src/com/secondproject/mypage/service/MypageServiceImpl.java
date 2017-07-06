package com.secondproject.mypage.service;

import java.util.List;
import java.util.Map;

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
	public List<FollowCategoryDto> followCategoryListView(Map<String, Object> map) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryListView(map);
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
	public List<FollowUserDto> followListView(Map<String, Object> map) {
		return MypageFollowDaoImpl.getMypageFollowDao().followListView(map);
	}

	@Override
	public int followdelete(int followUserId) {
		return MypageFollowDaoImpl.getMypageFollowDao().followdelete(followUserId);
	}

	@Override
	public int followCategoryDelete(int followCategoryId) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryDelete(followCategoryId);
	}

	@Override
	public int followModify(FollowUserDto fudto) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followModify(fudto);
	}

	@Override
	public int followCategoryModify(int cateId,int seq) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followCategoryModify(cateId, seq);
	}

	@Override
	public int totalFollowUserCount(Map<String, Object> params) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().totalFollowUserCount(params);
	}

	@Override
	public List<FollowUserDto> followselect(Map<String, Object> params) {
		
		return MypageFollowDaoImpl.getMypageFollowDao().followselect(params);
	}

	

}
