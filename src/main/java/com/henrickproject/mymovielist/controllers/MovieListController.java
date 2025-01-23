package com.henrickproject.mymovielist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrickproject.mymovielist.dto.MovieDTO;
import com.henrickproject.mymovielist.dto.MovieListDTO;
import com.henrickproject.mymovielist.dto.MovieMinDTO;
import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.services.MovieListService;
import com.henrickproject.mymovielist.services.MovieService;

@RestController
@RequestMapping(value = "/lists")
public class MovieListController {
	
	@Autowired
	private MovieListService movieListService;
	
	@GetMapping
	public List<MovieListDTO> findAll(){
		List<MovieListDTO> result = movieListService.findAll();
		return result;
	}
}
