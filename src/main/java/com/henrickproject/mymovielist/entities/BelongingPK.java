package com.henrickproject.mymovielist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private MovieList list;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Movie movie, MovieList list) {
		super();
		this.movie = movie;
		this.list = list;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public MovieList getList() {
		return list;
	}

	public void setList(MovieList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(list, movie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(list, other.list) && Objects.equals(movie, other.movie);
	}
	
	
}
