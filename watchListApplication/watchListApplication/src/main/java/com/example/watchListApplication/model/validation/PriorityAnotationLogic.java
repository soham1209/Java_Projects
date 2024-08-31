package com.example.watchListApplication.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityAnotationLogic implements ConstraintValidator<Priority,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value.trim().length()==1 && "LHM".contains(value.trim());
	}

}
 