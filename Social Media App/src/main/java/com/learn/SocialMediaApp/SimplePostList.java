package com.learn.SocialMediaApp;

import java.util.ArrayList;

public class SimplePostList implements PostList {

	ArrayList<Post> postList;

	public void init() {
		Post post = new SimplePost();
		post.setMessage("from DB");
		postList.add(post);
	}

	public void destroy() {
		System.out.println("Post List destroyed!");
	}

	public SimplePostList() {
		this.postList = new ArrayList<Post>();
	}

	@Override
	public ArrayList<Post> getAllPosts() {

		return this.postList;
	}

	@Override
	public Post getPost(int i) {
		return this.postList.get(i);
	}

	@Override
	public void setPost(Post post) {
		this.postList.add(post);

	}

	@Override
	public int size() {
		return this.postList.size();
	}

}
