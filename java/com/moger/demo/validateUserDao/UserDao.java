package com.moger.demo.validateUserDao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.moger.demo.entities.Book;



public class UserDao {
	/*

	public long authenticate(String email, String password) {
		try {
			String query = "Select id from User where email = '" + email + "' and password = '" + password + "'";
			Session  session = em.unwrap(Session.class);
			Query<Book> query = session.createQuery("FROM Book  WHERE id='"+id+"' ", Book.class);
			Book bk = query.getSingleResult();
				return rs.getLong("id");				
	    				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return -1;
	}*/

}
