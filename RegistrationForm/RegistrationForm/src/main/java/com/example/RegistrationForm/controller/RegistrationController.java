package com.example.RegistrationForm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegistrationForm.model.Student;
import com.example.RegistrationForm.service.RegistrationService;


@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/read")
	public String home() {
		return "index";
	}
	
	@PostMapping("/regester")
	public void regester(@ModelAttribute Student u) {
		
		System.out.println(u);
		
		registrationService.register(u);
	}
	
}
