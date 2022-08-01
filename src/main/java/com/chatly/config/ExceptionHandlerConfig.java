package com.chatly.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		List<Error> errorList = createErrorList(ex.getBindingResult());
		
		return handleExceptionInternal(ex, errorList, headers, status, request);
	}
	
	private List<Error> createErrorList(BindingResult bindingResult) {
		List<Error> errorList = new ArrayList<>();
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String simpleMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String defultMessage = fieldError.getDefaultMessage();
			String fullMessage = fieldError.toString();
			
			errorList.add(new Error(simpleMessage, defultMessage, fullMessage));
		}
		
		return errorList;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private static class Error{
		private String simpleMessage;
		private String defultMessage;
		private String fullMessage;			
	}
}
