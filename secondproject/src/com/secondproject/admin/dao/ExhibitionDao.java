package com.secondproject.admin.dao;

import java.util.List;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;

public interface ExhibitionDao {

	int getNextSeq();
	int writeExhibition(ExhibitionDetailDto exhibitionDetailDto);
	
	List<ExhibitionDto> listExhibition();
	ExhibitionDetailDto viewExhibition(int seq);
}
