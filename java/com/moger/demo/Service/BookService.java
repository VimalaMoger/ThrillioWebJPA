package com.moger.demo.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.moger.demo.entities.Book;


public interface BookService {
	
		Book saveBookInfo(Book emp);
		List<Book> getAllBooks();
		Book getBookById(Long id);
		Book updateBook(Book book,Long id);
		void deleteBook(Long id);
		Book getBooks(long userId);
		long authenticate(String email, String password) throws SQLException;
	}
