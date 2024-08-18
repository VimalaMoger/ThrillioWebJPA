package com.moger.demo.entities;

import lombok.Data;

@Data
public class UserBookmark {
	private User user;
	private Bookmark bookmark;
	public UserBookmark(User user, Bookmark bookmark){
		this.user=user;
		this.bookmark=bookmark;
	}
}
