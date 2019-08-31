package com.nc.Bloggify.service;

import com.nc.Bloggify.dao.IViewArticle;
import com.nc.Bloggify.dao.ViewArticle;
import com.nc.Bloggify.dto.User;

public class ViewArticleService implements IViewArticleService {

	IViewArticle va = new ViewArticle();

	@Override
	public User viewArticle(String title) {
		return va.viewArticle(title);
	}
}
