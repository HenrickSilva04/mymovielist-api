package com.henrickproject.mymovielist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrickproject.mymovielist.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long > {
	
}
