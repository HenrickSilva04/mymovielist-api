package com.henrickproject.mymovielist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrickproject.mymovielist.dto.MovieMinDTO;
import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<MovieMinDTO> findAll(){
		List<MovieMinDTO> result = movieService.findAll();
		return result;
	}
}
