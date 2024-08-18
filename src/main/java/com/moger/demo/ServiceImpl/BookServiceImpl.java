package com.moger.demo.ServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.moger.demo.exception.BookNotFoundException;
import com.moger.demo.entities.Book;
import com.moger.demo.entities.User;
import com.moger.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	//bookmark books
	private static List<Book> bookmarks = new ArrayList<>();
	//Injecting a bean using autowired
	@Autowired
	PasswordEncoder passwordEncoder;
	//@Autowired
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public Book saveBookInfo(Book book) {
		Session session = em.unwrap(Session.class);
		session.save(book);
		return book;
	}

	@Transactional
	@Override
	public List<Book> getAllBooks() {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("from Book", Book.class);
		List<Book> list = query.getResultList();
		return list;
	}

	@Transactional
	@Override
	public Book getBookById(Long id) throws BookNotFoundException {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("FROM Book  WHERE id=?1 ", Book.class);
		query.setParameter(1, id);
		Book bk = (Book) query.getSingleResult();
		if (bk == null) {
			// throw new NoResultException("Book not found");
			throw new BookNotFoundException("Book not found");
		}
		return bk;
	}

	@Transactional
	@Override
	public Book updateBook(Book book, Long eid) throws BookNotFoundException {
		Session session = em.unwrap(Session.class);
		MutationQuery query = session.createNativeMutationQuery("update Book  set title=?1, image_url=?2, publication_year=?3,publisher_id=?4,book_genre_id=?5,amazon_rating=?6" + " where id =?7");
		query.setParameter(1, book.getTitle());
		query.setParameter(2, book.getImage_url());
		query.setParameter(3, book.getPublicationYear());
		query.setParameter(4, book.getPublisherId());
		query.setParameter(5, book.getGenre());
		query.setParameter(6, book.getAmazonRating());
		query.setParameter(7, eid);
		int result = query.executeUpdate();
		if (result > 0) {
			return getBookById(eid);
		} else {
			throw new BookNotFoundException("Book not found");
		}
	}

	@Transactional
	@Override
	public String deleteBook(Long id) throws BookNotFoundException {
		Session session = em.unwrap(Session.class);
		MutationQuery query = session.createNativeMutationQuery("DELETE from Book WHERE id =:id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		if (result > 0) {
			return "deleted";
		} else {
			throw new BookNotFoundException("Book not found");
		}
	}

	@Override
	public Book getBooks(long bookId) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("FROM Book b join b.book_user WHERE id='" + bookId + "' ", Book.class);
		Book bk = (Book) query.getSingleResult();
		return bk;
	}

	public Optional<User> authenticate(String email, String password) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("From User where email='" + email + "' ", User.class);
		Optional<User> user = Optional.ofNullable((User) query.getSingleResult());
		return user;
	}

	@Transactional
	@Override
	public User saveUser(User user) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);

		Session session = em.unwrap(Session.class);
		session.persist(user);
		return user;
	}

	@Override
	public Collection<Book> saveBooks(Long id) {
		//Session session= em.unwrap(Session.class);
		Book bk = getBookById(id);
		bookmarks.add(bk);
		return bookmarks;
	}



}	

	

