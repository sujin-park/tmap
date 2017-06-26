package com.secondproject.admin.service;

import java.util.List;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.shop.model.ShopDto;

public interface ExhibitionService {

	int writeExhibition(ExhibitionDetailDto exhibitionDetailDto);
	List<ExhibitionDto> listExhibition(String key, String word, String order, String column, int pg);
	ExhibitionDetailDto viewExhibition(int seq);
	List<ShopDto> shopExhibition(String key, String word, String order, String column);
	int deleteExhibition(String[] exhibitions);
	
	int plusExhibition(String[] shops, int seq);
	int modifyExhibition(ExhibitionDto exhibitionDto);
	
	List<ShopDto> shopUpdated(int seq);
}
