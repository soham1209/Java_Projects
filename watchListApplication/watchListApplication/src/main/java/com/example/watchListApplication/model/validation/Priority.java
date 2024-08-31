package com.example.watchListApplication.model.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityAnotationLogic.class)
public @interface Priority {
	
	String message() default "Please enter L, M, H only";
	
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default{};
}
 	