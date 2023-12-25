package com.example.api.API.ControllerAdvise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.api.API.Exception.ItemNotFoundException;

@ControllerAdvice
public class ApplicaitonExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String itemNotFoundHandler(ItemNotFoundException ex) {
		return ex.getMessage();
	}
}
