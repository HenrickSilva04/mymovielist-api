package com.henrickproject.mymovielist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrickproject.mymovielist.dto.MovieDTO;
import com.henrickproject.mymovielist.dto.MovieListDTO;
import com.henrickproject.mymovielist.dto.MovieMinDTO;
import com.henrickproject.mymovielist.dto.ReplacementDTO;
import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.services.MovieListService;
import com.henrickproject.mymovielist.services.MovieService;

@RestController
@RequestMapping(value = "/lists")
public class MovieListController {
	
	@Autowired
	private MovieListService movieListService;
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<MovieListDTO> findAll(){
		List<MovieListDTO> result = movieListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/movies")
	public List<MovieMinDTO> findByList(@PathVariable Long listId){
		List<MovieMinDTO> result = movieService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		movieListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
	
	
}
