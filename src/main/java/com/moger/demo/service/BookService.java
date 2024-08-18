package com.moger.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.moger.demo.exception.BookAlreadyExistsException;
import com.moger.demo.exception.BookNotFoundException;
import com.moger.demo.entities.Book;
import com.moger.demo.entities.User;

public interface BookService {
	
		Book saveBookInfo(Book emp) throws BookAlreadyExistsException;
		List<Book> getAllBooks();
		Book getBookById(Long id) throws BookNotFoundException;;
		Book updateBook(Book book,Long id);
		String deleteBook(Long id);
		Book getBooks(long userId);
		Optional<User> authenticate(String email, String password);
		User saveUser(User user);
		Collection<Book> saveBooks(Long id);
		
	}
