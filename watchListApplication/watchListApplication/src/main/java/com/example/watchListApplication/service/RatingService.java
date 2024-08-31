package com.example.watchListApplication.service;

import javax.swing.Spring;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	String apiUrlSpring = "https://www.omdbapi.com/?apikey=f5b8436&t=";
	
	public String getMovieRating(String title) {
		// TODO Auto-generated method stub
		try {
			//try to fetch the rating by callaing api omdb api
			RestTemplate template = new RestTemplate();
			//we are going to call api url + title
			ResponseEntity< ObjectNode> response = template.getForEntity(apiUrlSpring + title,ObjectNode.class);
			//for geting json body form objectNode
			ObjectNode jsonObjectNode = response.getBody();
//			System.out.println(jsonObjectNode.path("imdbRating").asText());
			return jsonObjectNode.path("imdbRating").asText();
		} 
		catch (Exception e) {
			// user entered rating taken
			System.out.println("Either movie name not available or api is down "+e.getMessage());
			return null;
		}
	}
}
