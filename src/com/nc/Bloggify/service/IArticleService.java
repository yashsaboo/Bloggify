package com.nc.Bloggify.service;

import java.util.List;

import com.nc.Bloggify.dto.User;

public interface IArticleService {

	List<User> getArticleTitle();
	List<User> getArticleTitle1(String username);

}