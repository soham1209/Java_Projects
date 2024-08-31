package com.example.watchListApplication.model;

import com.example.watchListApplication.model.validation.Priority;
import com.example.watchListApplication.model.validation.Rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Plese enter the title")
	private String title;
	
	@Rating
	private float rating;
	@Priority
	private String priority;
	
	@Size(max = 50,message = "Comment should be maximum 50 characters")
	private String comment;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer id, String title, float rating, String priority, String comment) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.priority = priority;
		this.comment = comment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", rating=" + rating + ", priority=" + priority + ", comment="
				+ comment + "]";
	}
	
}
