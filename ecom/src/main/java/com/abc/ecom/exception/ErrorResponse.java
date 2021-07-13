package com.abc.ecom.exception;

import org.springframework.stereotype.Component;
/**
 * 
 * @author supriya
 * date - 10-Jul-2021
 */
@Component
public class ErrorResponse {
	
	private String error;
	private int status;
	
	/**
	 * This method is to get Error
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * This method is to set Error
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * This method is to get Status
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * This method is to set Status
	 * @param status 
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	

}
