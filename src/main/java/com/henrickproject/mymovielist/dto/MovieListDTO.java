package com.henrickproject.mymovielist.dto;

import com.henrickproject.mymovielist.entities.MovieList;

public class MovieListDTO {
	
	private Long id;
	private String name;
	
	public MovieListDTO() {
		
	}

	public MovieListDTO(MovieList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
