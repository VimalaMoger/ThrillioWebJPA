package com.moger.demo.DataSupplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class MessageBean {
	public  static void loadData() {
		String sqlUser = "INSERT INTO User(email,password,first_name,last_name,gender_id,user_type_id, created_date) values('user0@semanticsquare.com', 'test', 'John','M',0,0,NOW()), ('user1@semanticsquare.com','test','Sam','M',0,0,NOW()),('user2@semanticsquare.com', 'test', 'Anita','M',1,1,NOW()),('user3@semanticsquare.com', 'test', 'Sara','M',1,1,NOW()),('user4@semanticsquare.com', 'test', 'Dheeru','M',0,2,NOW())";
		String sqlPublisher = "INSERT INTO Publisher(name) values('Wilder'),('Dover Publications'),('Touchstone'),('O''Reilly Media'),('Prentice Hall')";
		String sqlAuthor = "INSERT INTO Author(name) values('Henry David Thoreau'),('Ralph Waldo Emerson'),('Lillian Eichler Watson'),('Eric Freeman'),('Bert Bates'),('Kathy Sierra'), ('Elisabeth Robson'),('Joshua Bloch')";
		String sqlBook ="INSERT INTO Book(title, publication_year,publisher_id, book_genre_id, amazon_rating,image_url) values('Walden',1854, 1, 6, 4.3,'https://images.gr-assets.com/books/1465675526l/16902.jpg'),('Self-Reliance and Other Essays', 1993, 2, 6, 4.5,'https://images.gr-assets.com/books/1520778510l/123845.jpg'),('Light From Many Lamps', 1988, 3, 6, 5.0,'https://images.gr-assets.com/books/1347739312l/1270698.jpg'),('Head First Design Patterns', 2004, 4, 10, 4.5,'https://images.gr-assets.com/books/1408309444l/58128.jpg'),('Effective Java Programming Language Guide', 2007,5, 10, 4.9,'https://images.gr-assets.com/books/1433511045l/105099.jpg')";
		String sqlBookAuthor = "INSERT INTO Book_Authors(book_id,authors_id,index_column) values(1, 1,9), (2, 2,2), (3, 3,3), (4, 4,4), (4, 5,5), (4, 6,6), (4,7,7), (5, 8,8)";
		String sqlBookUser = "INSERT INTO Book_User(book_id,user_id) values(4, 5),(4,1), (3,1)";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(sqlUser).executeUpdate();
        entityManager.createNativeQuery(sqlPublisher).executeUpdate();
        entityManager.createNativeQuery(sqlAuthor).executeUpdate();
        entityManager.createNativeQuery(sqlBook).executeUpdate();
        entityManager.createNativeQuery(sqlBookAuthor).executeUpdate();
        entityManager.createNativeQuery(sqlBookUser).executeUpdate();
        entityManager.getTransaction().commit();
	}
	public  static void main(String[] args) {
		loadData();
		
	}
}
