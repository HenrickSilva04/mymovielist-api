package com.henrickproject.mymovielist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.henrickproject.mymovielist.projections.MovieMinProjection;
import com.henrickproject.mymovielist.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long > {
	
	@Query(nativeQuery = true, value = """
			SELECT tb_movie.id, tb_movie.title, tb_movie.movie_year AS `year`, tb_movie.img_url AS imgUrl,
			tb_movie.short_description AS shortDescription, tb_belonging.position
			FROM tb_movie
			INNER JOIN tb_belonging ON tb_movie.id = tb_belonging.movie_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<MovieMinProjection> searchByList(Long listId);
}
