package com.secondproject.joinlogin.service;

import com.secondproject.joinlogin.dao.JoinDaoImpl;
import com.secondproject.userdto.UserDto;

public class JoinServiceImpl implements JoinService {

	private static JoinService joinService;
	
	static {
		joinService = new JoinServiceImpl();
	}
	
	private JoinServiceImpl() {}
	
	public static JoinService getJoinService() {
		return joinService;
	}

	@Override
	public int join(UserDto userDto) {
		return JoinDaoImpl.getJoinDao().join(userDto);
	}

	@Override
	public int idCheck(String sid) {
		return JoinDaoImpl.getJoinDao().idCheck(sid);
	}

}
