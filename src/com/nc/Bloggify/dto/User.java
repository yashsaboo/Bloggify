package com.nc.Bloggify.dto;

public class User {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int claps;
	private String title;
	private String data;
	private String rePassword;
	private String commentdata;
	
	public String getCommentdata() {
		return commentdata;
	}
	public void setCommentdata(String commentdata) {
		this.commentdata = commentdata;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getClaps() {
		return claps;
	}
	public void setClaps(int claps) {
		this.claps = claps;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
