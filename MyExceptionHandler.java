package com.nv.questionbank.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(QuestionsNotFound.class)
	protected ResponseEntity<Object> handleQuestionsNotFound(QuestionsNotFound e) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("responseCode", HttpStatus.INTERNAL_SERVER_ERROR);
		body.put("message", e.getMessage());

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
