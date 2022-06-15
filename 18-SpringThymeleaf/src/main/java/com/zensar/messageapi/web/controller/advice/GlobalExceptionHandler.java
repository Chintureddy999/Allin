package com.zensar.messageapi.web.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//This is used to handle Exception
public class GlobalExceptionHandler {
	//here you specify type of Exception
	@ExceptionHandler(Exception.class)
    public String handleException()
    {
        return "error";
    }
	

}
