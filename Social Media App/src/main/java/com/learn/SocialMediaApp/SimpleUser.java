package com.learn.SocialMediaApp;

public class SimpleUser implements User {
	String userName;
	PostList postList;

//	public SimpleUser(PostList postList) {
//		this.postList = postList;
//	}

	public void init() {
		System.out.println("Simple User created !");

	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public PostList getPostList() {
		// TODO Auto-generated method stub
		return this.postList;
	}

	@Override
	public void setPostList(PostList postList) {
		this.postList = postList;

	}

}
