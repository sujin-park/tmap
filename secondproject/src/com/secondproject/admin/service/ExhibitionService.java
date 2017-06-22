package com.secondproject.admin.service;

import java.util.List;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.shop.model.ShopDto;

public interface ExhibitionService {

	int writeExhibition(ExhibitionDetailDto exhibitionDetailDto);
	List<ExhibitionDto> listExhibition(String key, String word, String order, String column);
	ExhibitionDetailDto viewExhibition(int seq);
	List<ShopDto> shopExhibition();
	int deleteExhibition(int seq);
}
