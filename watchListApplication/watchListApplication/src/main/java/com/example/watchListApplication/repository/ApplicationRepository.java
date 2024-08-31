package com.example.watchListApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.watchListApplication.model.Movie;

@Repository
public interface ApplicationRepository extends JpaRepository<Movie, Integer>{

}
