package com.example.watchListApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.watchListApplication.model.Movie;
import com.example.watchListApplication.service.ApplicationService;

import jakarta.validation.Valid;

@RestController
public class ApplcationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	//watchlist form page showing
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistForm(@RequestParam(required = false) Integer id) { //requestParm is by defalt true 
																						//we need to make it false for we only need it for update
		String viewName = "watchlistItemForm";
		
		Map<String, Object> model = new HashMap<>();
		
		//if id null when new we adding new movie
		if(id == null) {
			model.put("watchlistItem", new Movie());			
		}else {
			model.put("watchlistItem", applicationService.getMovieById(id));
		}
		
		return new ModelAndView(viewName,model);
	}
	
	//watch list form page sending data
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchlistForm(@Valid @ModelAttribute("watchlistItem") Movie movie,BindingResult bindingResult)//bindingresult catch error in the title error in watchlistform title 
	{
		if(bindingResult.hasErrors()) {
		// if error are there redisplay the form and let user enter again
			return new ModelAndView("watchlistItemForm");
		}
		//if id = 0 that means movie is new
		Integer id = movie.getId();
		if (id == null) {
			applicationService.create(movie);
		} else {
			applicationService.update(movie,id);
		} 
		
		//redirecting
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/watchlist");
		
		return new ModelAndView(redirectView);
	}
	
	//watchlist page
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movie> movies= applicationService.getAllMovies();
		
		model.put("watchlistrows", movies);
		model.put("noofmovies", movies.size());
		
		return new ModelAndView(viewName,model);
	}
	
	@PostMapping("/deleteFromList")
	public RedirectView deleteFromList(@RequestParam Integer id) {
		applicationService.deleteMovieById(id);
		return new RedirectView("/watchlist");
		
	}
	
	
}

