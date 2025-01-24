package com.henrickproject.mymovielist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.henrickproject.mymovielist.entities.Movie;
import com.henrickproject.mymovielist.entities.MovieList;

public interface MovieListRepository extends JpaRepository<MovieList, Long > {
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND movie_id = :movieId")
	void updateBelongingPosition(Long listId, Long movieId, Integer newPosition);
	
}
