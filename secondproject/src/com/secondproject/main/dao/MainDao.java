package com.secondproject.main.dao;

import java.util.List;

import com.secondproject.main.model.MainExhibitionDto;

public interface MainDao {

	List<MainExhibitionDto> listMainExhibition(); 
	MainExhibitionDto viewMainExhibition(int i);
}
