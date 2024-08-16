package com.example.RegistrationForm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegistrationForm.model.Student;
import com.example.RegistrationForm.repositry.RegistrationRepositry;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepositry repositry;
	
	public void register(Student u) {
		// TODO Auto-generated method stub
		
		repositry.save(u);	
	}
	
}
