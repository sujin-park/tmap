package com.secondproject.admin.service;

import java.util.HashMap;
import java.util.Map;

import com.secondproject.admin.dao.CommonDaoImpl;
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
		// 주 목적은 네비게이션 만드는것
		PageNavigation pageNavigation = new PageNavigation();
		int totalArticleCount = 0;
		 // root는 서비스에서 완성할 수 없음
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word); // 전체 글 수 는 나중에 key와 word가 필요하다
		if (board.equals("review")) {
			totalArticleCount = CommonDaoImpl.getCommonDao().totalReviewCount(map);
		} else {
			totalArticleCount = CommonDaoImpl.getCommonDao().totalArticleCount(map); // db
		}
		pageNavigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / 5 + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount-1) / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE < pg ); // 0으로 나누어 떨어지는 것은 1로 빼주면 됨
		pageNavigation.setPageNo(pg);
		System.out.println("commonservice end" + pg);
		return pageNavigation;
	}
}