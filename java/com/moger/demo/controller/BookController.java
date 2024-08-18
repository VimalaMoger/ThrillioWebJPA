package com.moger.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.moger.demo.Service.BookService;
import com.moger.demo.entities.Book;
import com.moger.demo.entities.User;




@Controller
public class  BookController{
	private BookService service;
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/books")
	public String listBooks(Model model) {
		List<Book> books =service.getAllBooks();
		model.addAttribute("books", books);
		return "book";
	}
	
	@GetMapping("/book/new")
	public String AddBook(Model model) {
		//create object to hold data
		Book book= new Book(); 
		model.addAttribute("book", book);
		return "Add_book";
				
	}
	@PostMapping("/book")
	public String saveBook(@ModelAttribute("book") Book book) {
		service.saveBookInfo(book);
		return  "redirect:/books";
		
	}
	@GetMapping("/book/edit/{id}")
	public String UpdateBook(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("book",service.getBookById(id));
		return "update";
		
	}

	@PostMapping("/book/{id}")
	public String updatingBook(@PathVariable("id") Long id,  @ModelAttribute("book") Book book,Model model) {
		
		service.updateBook(book, id);
		return  "redirect:/books";
		
	}
	@GetMapping("/book/{id}")
	public String DeleteBook(@PathVariable("id") Long id) {
		service.deleteBook(id);
		return  "redirect:/books";
	
	}
	@GetMapping("/book/save/{id}")
	public String SaveBooks(@PathVariable("id") Long id, Model model) {
		Collection<Book> books = new ArrayList<>();
		Book bk=service.getBooks(id);
		books.add(bk);
		model.addAttribute("books", books);
		return  "savedBooks";
	}

		
	}


