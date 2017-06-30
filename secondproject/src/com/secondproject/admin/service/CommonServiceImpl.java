package com.secondproject.admin.service;

import java.util.HashMap;
import java.util.Map;

import com.secondproject.admin.dao.CommonDaoImpl;
import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.util.BoardConstance;
import com.secondproject.util.PageNavigation;


// 1. private 생성자
// 2. static 변수 선언
// 3. static{} 객체 생성
// 4. 자신을 리턴하는 get method 생성
public class CommonServiceImpl implements CommonService {

	private static CommonService commonService; // interface 타입으로 잡기

	private CommonServiceImpl(){};

	static {

		commonService = new CommonServiceImpl();
	}

	public static CommonService getCommonService() {
		return commonService;
	}

	@Override
	public PageNavigation makePageNavigation(int pg, String key, String word, String board) {
		PageNavigation pageNavigation = new PageNavigation();
		int totalArticleCount = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("board", board);
		totalArticleCount = CommonDaoImpl.getCommonDao().totalArticleCount(map); // db
		pageNavigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / BoardConstance.LIST_SIZE + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount-1) / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE < pg ); // 0으로 나누어 떨어지는 것은 1로 빼주면 됨
		pageNavigation.setPageNo(pg);
		return pageNavigation;
	}

	@Override
	public PageNavigation mypagePageNavigation(int pg, String key, String word, String control) {
		PageNavigation pageNavigation = new PageNavigation();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("control", control);
		map.put("userId",2+"");
		int totalArticleCount = MypageFollowDaoImpl.getMypageFollowDao().totalArticleCount(map);
		
		int totalPageCount = (totalArticleCount - 1) / BoardConstance.MYPAGE_LIST_SIZE + 1;
		pageNavigation.setTotalArticleCount(totalArticleCount);
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstance.MYPAGE_PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount-1)/BoardConstance.MYPAGE_PAGE_SIZE == (pg-1)/BoardConstance.MYPAGE_PAGE_SIZE);
		pageNavigation.setPageNo(pg);
		return pageNavigation;
	}
}