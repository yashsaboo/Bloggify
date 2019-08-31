package com.nc.Bloggify.service;

import com.nc.Bloggify.dao.IUserData;
import com.nc.Bloggify.dao.UserData;

public class UserDataService implements IUserDataService {
	
	IUserData ud = new UserData();
		
	@Override
	public String userInfo(String username) {
		return ud.userInfo(username);
	}

	@Override
	public String totalClaps(String username) {
		// TODO Auto-generated method stub
		return ud.totalClaps(username);
	}
	
}
