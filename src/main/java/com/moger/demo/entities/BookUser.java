package com.moger.demo.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Data
@Entity
public class BookUser { 
	
    @EmbeddedId
    private BookUserId id;

    public BookUser() {
		super();
	}
	@ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id", nullable =false)
    private Book book;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    public BookUser(Book book, User user) {
        this.id = new BookUserId(book.getId(), user.getId());
        this.book = book;
        this.user = user;
   
    }

    
}
