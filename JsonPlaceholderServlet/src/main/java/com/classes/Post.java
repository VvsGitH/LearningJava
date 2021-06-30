package com.classes;

public class Post {
	private int id;
	private int userId;
	private String title;
	private String body;
	
	public Post(int id, int userId, String title, String body) {
		this.id = id;
		this.userId = userId;
		this.title = new String(title);
		this.body = new String(body);
	}
	
	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return String.format(" id: %d\n userId: %d\n title: %s\n body: %s\n", id, userId, title, body);
	}
}