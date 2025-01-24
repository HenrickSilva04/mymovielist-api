package com.henrickproject.mymovielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.henrickproject.mymovielist.dto.MovieDTO;
import com.henrickproject.mymovielist.dto.MovieListDTO;
import com.henrickproject.mymovielist.dto.MovieMinDTO;
import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.entities.MovieList;
import com.henrickproject.mymovielist.projections.MovieMinProjection;
import com.henrickproject.mymovielist.repositories.MovieListRepository;
import com.henrickproject.mymovielist.repositories.MovieRepository;

@Service
public class MovieListService {
	
	@Autowired
	private MovieListRepository movieListRepository;
	

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public List<MovieListDTO> findAll(){
		List<MovieList> result = movieListRepository.findAll();
		return result.stream().map(x -> new MovieListDTO(x)).toList();
		
	}
	
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<MovieMinProjection> list = movieRepository.searchByList(listId);
		MovieMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i<=max ; i++) {
			movieListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
