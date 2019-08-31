package com.nc.Bloggify.dao;

import java.util.List;

import com.nc.Bloggify.dto.User;

public interface IArticleList {

	List<User> getArticleTitle();
	List<User> getArticleTitle1(String username);

}