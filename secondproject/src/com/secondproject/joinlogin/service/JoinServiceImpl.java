package com.secondproject.joinlogin.service;

import java.util.HashMap;
import java.util.Map;

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
	public int idCheck(String sid) {
		return JoinDaoImpl.getJoinDao().idCheck(sid);
	}

	@Override
	public UserDto attest(String email, String password, String age, String gender) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("attestemail", email);
		map.put("attestpassword", password);
		map.put("attestage", age);
		map.put("attestgender", gender);
		return JoinDaoImpl.getJoinDao().attest(map);
	}

}
