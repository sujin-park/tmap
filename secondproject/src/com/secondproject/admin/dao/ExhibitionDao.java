package com.secondproject.admin.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.shop.model.ShopDto;

public interface ExhibitionDao {

//	int getNextSeq();
	int writeExhibition(ExhibitionDto exhibitionDto);
	
	List<ExhibitionDto> listExhibition(Map<String, String> map);
	ExhibitionDto viewExhibition(int seq);
	List<ShopDto> shopExhibition(Map<String, String> map);
	
	int deleteExhibition(String[] exhibitions);
	int plusExhibition(String[] shops, int seq);
	
	int modifyExhibition(ExhibitionDto exhibitionDto);
	
	List<ShopDto> shopUpdated(int seq);
	int deleteShopList(int exseq, int shopseq);
}
