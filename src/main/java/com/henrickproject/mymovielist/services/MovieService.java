package com.henrickproject.mymovielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrickproject.mymovielist.dto.MovieMinDTO;
import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<MovieMinDTO> findAll(){
		List<Movie> result = movieRepository.findAll();
		List<MovieMinDTO> dto = result.stream().map(x -> new MovieMinDTO(x)).toList();
		return dto;
	}
}
