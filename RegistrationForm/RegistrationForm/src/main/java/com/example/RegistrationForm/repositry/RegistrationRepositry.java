package com.example.RegistrationForm.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RegistrationForm.model.Student;

@Repository
public interface RegistrationRepositry extends JpaRepository<Student, Integer>{
	
}
