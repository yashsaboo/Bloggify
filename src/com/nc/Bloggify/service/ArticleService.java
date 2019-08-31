package com.nc.Bloggify.service;

import java.util.List;

import com.nc.Bloggify.dao.ArticleList;
import com.nc.Bloggify.dao.IArticleList;
import com.nc.Bloggify.dto.User;

public class ArticleService implements IArticleService {

	IArticleList al = new ArticleList();

	@Override
	public List<User> getArticleTitle() {
		return al.getArticleTitle();
	}
	
	@Override
	public List<User> getArticleTitle1(String username) {
		return al.getArticleTitle1(username);
	}
}
