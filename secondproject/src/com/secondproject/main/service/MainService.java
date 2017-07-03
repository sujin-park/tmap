package com.secondproject.main.service;

import java.util.List;

import com.secondproject.main.model.MainExhibitionDto;

public interface MainService {
	
	List<MainExhibitionDto> listMainExhibition(); 
	MainExhibitionDto viewMainExhibition(int i);
}
