package com.moger.demo.entities;

import java.util.Arrays;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import com.moger.demo.DataConstants.MovieGenre;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Movie extends Bookmark {
	@Id
    @GeneratedValue
	private long id;
	private String title;
	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private MovieGenre genre;
	private double imdbRating;


	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
				+ Arrays.toString(directors) + ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
	}

	@Override//stub
	public boolean isKidsFriendlyEligible() {
		// TODO Auto-generated method stub
		if(getGenre().equals(MovieGenre.HORROR) || getReleaseYear()==1942 || getCast()[0].contains("Orizon")) {
			return false;
		}
		return true;
	}
	

}
