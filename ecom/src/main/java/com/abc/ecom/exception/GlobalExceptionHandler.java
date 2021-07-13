package com.abc.ecom.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author supriya
 * date - 10-Jul-2021
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private ErrorResponse errorResponse;
	/**
	 * THis method is to handle ResourceAlreadyExistException
	 * @param Exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = ResourceAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handleResourceAlreadyExistingException(Exception e){
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	/**
	 * THis method is to handle ResourceNotFoundException
	 * @param Exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception e){
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	/**
	 * THis method is to handle ConstraintViolationException
	 * @param Exception
	 * @return ResponseEntity
	 */
	  @ExceptionHandler(javax.validation.ConstraintViolationException.class)
	  public ResponseEntity<ErrorResponse> inputValidationException(Exception e) {
	    	//ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setError("Invalid Input : " + e.getMessage());
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);

	    }
	
	
	  /**
	   * THis method is to handle MethodArgumentNotValidException
	   *  {@inheritDoc}
	   */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
	body.put("status", status.value());
	List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
			.collect(Collectors.toList());
	body.put("errors", errors);
	return new ResponseEntity<>(body,headers,status);		
	}


}
