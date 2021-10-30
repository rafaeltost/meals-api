package com.topinformation.MealsAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MealNotFoundException extends Throwable {
    public MealNotFoundException(Long id){
        super("Meal not found with id " + id);
    }
}
