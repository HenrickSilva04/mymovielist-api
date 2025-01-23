package com.henrickproject.mymovielist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.entities.MovieList;

public interface MovieListRepository extends JpaRepository<MovieList, Long > {
	
}
