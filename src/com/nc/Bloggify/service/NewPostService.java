package com.nc.Bloggify.service;

import com.nc.Bloggify.dao.INewPost;
import com.nc.Bloggify.dao.NewPost;
import com.nc.Bloggify.dto.User;

public class NewPostService implements INewPostService {

	INewPost np = new NewPost();
	
	@Override
	public boolean newPost(User user) {
		return np.newPost(user);
	}
}
