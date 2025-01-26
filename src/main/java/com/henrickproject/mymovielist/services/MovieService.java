package com.henrickproject.mymovielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.henrickproject.mymovielist.dto.MovieDTO;
import com.henrickproject.mymovielist.dto.MovieMinDTO;
import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.projections.MovieMinProjection;
import com.henrickproject.mymovielist.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public MovieDTO findById(@PathVariable Long listId) {
		Movie result = movieRepository.findById(listId).get();
		return new MovieDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<MovieMinDTO> findAll(){
		List<Movie> result = movieRepository.findAll();
		return result.stream().map(x -> new MovieMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<MovieMinDTO> findByList(Long listId){
		List<MovieMinProjection> result = movieRepository.searchByList(listId);
		return result.stream().map(x -> new MovieMinDTO(x)).toList();
	}
}
