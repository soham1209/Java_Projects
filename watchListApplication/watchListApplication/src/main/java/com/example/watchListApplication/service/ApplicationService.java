package com.example.watchListApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.watchListApplication.model.Movie;
import com.example.watchListApplication.repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private RatingService ratingService;
	
	public void create(Movie movie) {
	
		String rating = ratingService.getMovieRating(movie.getTitle()); 
		if (rating != null) {
			movie.setRating(Float.parseFloat(rating));
		}
		applicationRepository.save(movie);
	}
	
	public List<Movie> getAllMovies() {
		
		return applicationRepository.findAll();
	}
	
	public Movie getMovieById(Integer id) {
		return applicationRepository.findById(id).get();
	}

	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie toBeUpdated = getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setPriority(movie.getPriority());
		toBeUpdated.setComment(movie.getComment());
		
		applicationRepository.save(toBeUpdated);
	 }

	public void deleteMovieById(Integer id) {
		// TODO Auto-generated method stub
		 applicationRepository.deleteById(id);

	}
}
