
/* Controller To run angular applications */

package com.moger.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.moger.demo.exception.BookNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.moger.demo.entities.Book;
import com.moger.demo.entities.User;
import com.moger.demo.service.BookService;

@RestController
public class  BookAngularController{

	private BookService service;
	public BookAngularController(BookService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getbooks")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Book> listBooks() {
		List<Book> books =service.getAllBooks();
		return books;
	}

	@PostMapping("/addbook")
	@CrossOrigin(origins = "http://localhost:4200")
	public Book saveBook(@RequestBody Book book) {
		service.saveBookInfo(book);
		return  book;
	}

	@GetMapping("/getbook/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") Long id){
		 try{
			return new ResponseEntity<>(service.getBookById(id), HttpStatus.OK);
		 }catch(BookNotFoundException ex ){
			  return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
		 }
	}

	@PostMapping("/editbook/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id,  @RequestBody Book b) {
		try{
			return new ResponseEntity<>(service.updateBook(b, id), HttpStatus.OK);
		}catch(BookNotFoundException ex ){
			  return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletebook/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Map<String,Boolean>> DeleteBook(@PathVariable("id") Long id) {
		 try{
			 	String r=service.deleteBook(id);
			 	Map<String,Boolean> response = new HashMap<>();
			 	response.put(r, Boolean.TRUE);
				return new ResponseEntity<>(response, HttpStatus.OK);
		 }catch(BookNotFoundException ex ){
				  return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
		 }
	}

	@PostMapping("/login/user")
	 public String validateUser(@ModelAttribute(name="loginForm") User user, HttpSession session) {    //, HttpServletRequest request) {
				 String email = user.getEmail();
				 String password = user.getPassword();
			     Optional<User> u=service.authenticate(email, password);
			     session.setAttribute("name", email);
		    return "redirect:/books";
	}
}


