package com.secondproject.admin.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.shop.model.ShopDto;

public interface ExhibitionDao {

	int getNextSeq();
	int writeExhibition(ExhibitionDetailDto exhibitionDetailDto);
	
	List<ExhibitionDto> listExhibition(Map<String, String> map);
	ExhibitionDetailDto viewExhibition(int seq);
	List<ShopDto> shopExhibition();
	
	int deleteExhibition(int seq);
}
