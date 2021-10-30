package com.topinformation.MealsAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MealsListNotFoundException extends Throwable {
    public MealsListNotFoundException(){
        super("An internal server error has occurred or there are no meals registered.");
    }
}
