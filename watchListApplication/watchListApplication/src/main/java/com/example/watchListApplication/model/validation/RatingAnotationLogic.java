package com.example.watchListApplication.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingAnotationLogic implements ConstraintValidator<Rating,Float>{

	@Override
	public boolean isValid(Float value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value>5 && value<=10;
	}

}
