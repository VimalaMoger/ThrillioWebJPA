package com.moger.demo.controller;


import com.moger.demo.entities.Book;
import com.moger.demo.entities.User;
import com.moger.demo.service.BookService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class  BookController{
	@Autowired
	PasswordEncoder passwordEncoder;
	String email;
	private BookService service;
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/books")
	public String listBooks(Model model) {
		List<Book> books =service.getAllBooks();
		model.addAttribute("books", books);
		model.addAttribute("message", email);
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
	public String getSingleBook(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("book",service.getBookById(id));
		return "update";
	}

	@PostMapping("/book/{id}")
	public String updateBook(@PathVariable("id") Long id,  @ModelAttribute("book") Book book,Model model) {
		service.updateBook(book, id);
		return  "redirect:/books";
	}
	@GetMapping("/book/{id}")
	public String DeleteBook(@PathVariable("id") Long id) {
		service.deleteBook(id);
		return "redirect:/books";
	}
	@GetMapping("/book/save/{id}")
	public String SaveBooks(@PathVariable("id") Long id, Model model) {
		Collection<Book> books= service.saveBooks(id);
		model.addAttribute("books", books);
		return "savedBooks";
	}
	@GetMapping("/")
	public String loginUser(Model model) {
		User user= new User();
		model.addAttribute("loginForm", user);
		return "index";
	}
	@PostMapping("/user")
	public String validateUser(@Valid @ModelAttribute(name="loginForm") User user, BindingResult result, Model model, HttpSession session) {    //, HttpServletRequest request) {
		if(result.hasErrors())
			return "index";
		String email = user.getEmail();
		String password = user.getPassword();
		Optional<User> optionalUser = service.authenticate(email, password);
		session.setAttribute("name", email);
		if(optionalUser.isPresent()) {
			if (passwordEncoder.matches(password,optionalUser.get().getPassword()))
				return "redirect:/books";
		}
		model.addAttribute("error", "Incorrect password Please try again");
		return "index";
	}
	@GetMapping("/user/new")
	public String AddUser(Model model) {
		User user= new User(); 
		model.addAttribute("registrationForm", user);
		return "register";
	}
	
	@PostMapping("/registration")
	public String RegisterUser(@Valid @ModelAttribute(name="registrationForm") User user, BindingResult result) {
		if(result.hasErrors())
			return "register";
		service.saveUser(user);
		return "redirect:/user/new?success";
	}

	@GetMapping("/logout")
	public String logoutUser(Model model) {
		User user= new User();
		model.addAttribute("loginForm", user);
		return "index";
	}
}



