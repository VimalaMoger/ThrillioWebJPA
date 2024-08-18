 package com.moger.demo.entities;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.cfg.AccessType;

import com.moger.demo.DataConstants.BookGenre;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	

	@Column(nullable = false)
	private String title;

	private String image_url;
	@Column(name="publication_year")
	private int publicationYear;
	
	//@JoinColumn(name="publisher_id")
	private long publisherId;
	
	@OneToMany(targetEntity=Author.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@OrderColumn(insertable = true,name="index_column")
	
	private List<Author> authors;
	
	@Column(name="book_genre_id")
	private BookGenre genre;
	@Column(name="amazon_rating")
	private double amazonRating;
	
	public Book() {}
	
	@Override
	public String toString() {
		return "Book [ title=" + title + ", image_url=" + image_url + ", publicationYear="
				+ publicationYear + ", publisherId=" + publisherId + ", authors=" + authors + ", genre=" + genre
				+ ", amazonRating=" + amazonRating + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public long getPublisherId() {
		return publisherId;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="author")
	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	


	
}
