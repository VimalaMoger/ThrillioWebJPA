package com.moger.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.moger.demo.DataConstants.Gender;
import com.moger.demo.DataConstants.UserType;


@Entity

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@Column(name = "first_name" ,nullable = false)
	private String firstName;
	@Column(nullable = false , name = "last_name")
	private String lastName;  
	
	@Column(name = "gender_id")
	
	private Gender gender;
	
	@Column(name = "user_type_id")

	private String userType;
	@Column(nullable = false)
	private Date created_date;

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public User() {
	}

/*
	public static void main(String[] args) {
		
		//String sqlAlterBook_Author="alter table Book_Author modify column index_column id INTEGER NOT NULL AUTO_INCREMENT";
		String sqlUser = "INSERT INTO User(email,password,first_name,last_name,gender_id,user_type_id, created_date) values('user0@semanticsquare.com', 'test', 'John','M',0,0,NOW()), ('user1@semanticsquare.com','test','Sam','M',0,0,NOW()),('user2@semanticsquare.com', 'test', 'Anita','M',1,1,NOW()),('user3@semanticsquare.com', 'test', 'Sara','M',1,1,NOW()),('user4@semanticsquare.com', 'test', 'Dheeru','M',0,2,NOW())";
		String sqlPublisher = "INSERT INTO Publisher(name) values('Wilder'),('Dover Publications'),('Touchstone'),('O''Reilly Media'),('Prentice Hall')";
		String sqlAuthor = "INSERT INTO Author(name) values('Henry David Thoreau'),('Ralph Waldo Emerson'),('Lillian Eichler Watson'),('Eric Freeman'),('Bert Bates'),('Kathy Sierra'), ('Elisabeth Robson'),('Joshua Bloch')";
		String sqlBook ="INSERT INTO Book(title, publication_year,publisher_id, book_genre_id, amazon_rating,image_url) values('Walden',1854, 1, 6, 4.3,'https://images.gr-assets.com/books/1465675526l/16902.jpg'),('Self-Reliance and Other Essays', 1993, 2, 6, 4.5,'https://images.gr-assets.com/books/1520778510l/123845.jpg'),('Light From Many Lamps', 1988, 3, 6, 5.0,'https://images.gr-assets.com/books/1347739312l/1270698.jpg'),('Head First Design Patterns', 2004, 4, 10, 4.5,'https://images.gr-assets.com/books/1408309444l/58128.jpg'),('Effective Java Programming Language Guide', 2007,5, 10, 4.9,'https://images.gr-assets.com/books/1433511045l/105099.jpg')";
	
		String sqlBookAuthor = "INSERT INTO Book_Author(book_id,authors_id,index_column) values(1, 1,1), (2, 2,2), (3, 3,3), (4, 4,4), (4, 5,5), (4, 6,6), (4,7,7), (5, 8,8)";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        //entityManager.createNativeQuery(sqlAlterBook_Author);
        entityManager.createNativeQuery(sqlUser).executeUpdate();
        entityManager.createNativeQuery(sqlPublisher).executeUpdate();
        entityManager.createNativeQuery(sqlAuthor).executeUpdate();
        entityManager.createNativeQuery(sqlBook).executeUpdate();
      
        entityManager.createNativeQuery(sqlBookAuthor).executeUpdate();
        entityManager.getTransaction().commit();
        
        
	
		
	}
*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstNsme(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender2) {
		this.gender = gender2;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", userType=" + userType + "]";
	}

}
