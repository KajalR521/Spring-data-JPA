package com.cg.rest.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(value =HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { Exception.class })
	public ErrorInformation handleConflict(Exception e, HttpServletRequest req) {
		String msg = e.getMessage();
		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response = new ErrorInformation(uri, msg, dt);
		return response;
	}
	
	@ResponseBody
	@ResponseStatus(value =HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoSuchEmployeeFoundException.class , NoSuchDepartmentFoundException.class})
	public ErrorInformation handleConflict( NoSuchDepartmentFoundException e1,NoSuchEmployeeFoundException e2, HttpServletRequest req) {
		String msg1 = e1.getMessage();
		String msg2 = e2.getMessage();
		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response1 = new ErrorInformation(uri, msg1, dt);
		ErrorInformation response2 = new ErrorInformation(uri, msg2, dt);

		return response1;
	}
}
