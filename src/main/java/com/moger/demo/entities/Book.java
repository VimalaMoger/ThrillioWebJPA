 package com.moger.demo.entities;
import java.util.List;
import jakarta.persistence.*;
import com.moger.demo.DataConstants.BookGenre;
import lombok.*;

 @Entity
@Data
@NoArgsConstructor
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
	

	



	


	
}
