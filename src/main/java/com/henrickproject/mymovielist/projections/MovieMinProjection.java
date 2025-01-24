package com.henrickproject.mymovielist.projections;

public interface MovieMinProjection {
	
	Long getId();
	String getTitle();
	Integer getMovieYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
	
}
