package com.secondproject.admin.service;

import java.util.List;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;

public interface ExhibitionService {

	int writeExhibition(ExhibitionDetailDto exhibitionDetailDto);
	
	List<ExhibitionDto> listExhibition();
	
	ExhibitionDetailDto viewExhibition(int seq);
}