package com.secondproject.admin.service;

import com.secondproject.util.PageNavigation;

public interface CommonService {

	
	PageNavigation makePageNavigation(int pg, String key, String word); // pagenavigation에서 페이징 처리 해주는거 함

}