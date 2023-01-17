package com.cg.rest.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.rest.exception.CourseNotFoundException;
import com.cg.rest.exception.ErrorInformation;
import com.cg.rest.exception.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { StudentNotFoundException.class })
	public ErrorInformation handleConflict(StudentNotFoundException e1, HttpServletRequest req) {
		String msg1 = e1.getMessage();

		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response1 = new ErrorInformation(uri, msg1, dt);

		return response1;
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { CourseNotFoundException.class })
	public ErrorInformation handleConflict(CourseNotFoundException e1, HttpServletRequest req) {
		String msg2 = e1.getMessage();

		String uri = req.getRequestURI().toString();
		LocalDateTime dt1 = LocalDateTime.now();
		ErrorInformation response2 = new ErrorInformation(uri, msg2, dt1);

		return response2;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)

	@ResponseBody

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })

	public ErrorInformation handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest req) {

		String msg = "validation faild";

		FieldError error = ex.getFieldError();

		if (error != null)

			msg = error.getDefaultMessage();
		LocalDateTime dt = LocalDateTime.now();
		return new ErrorInformation(req.getRequestURI(), msg,dt);

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { Exception.class })
	public ErrorInformation handleConflict(Exception e, HttpServletRequest req) {
		String msg = e.getMessage();
		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response = new ErrorInformation(uri, msg, dt);
		return response;
	}

}
