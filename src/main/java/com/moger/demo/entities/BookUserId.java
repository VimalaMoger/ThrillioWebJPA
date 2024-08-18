package com.moger.demo.entities;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class BookUserId implements Serializable {  
   
    private long bookId;
    private long userId;
    public BookUserId(){}
	public BookUserId(long bookId, long userId) {
		super();
		this.bookId = bookId;
		this.userId = userId;
	}
}
