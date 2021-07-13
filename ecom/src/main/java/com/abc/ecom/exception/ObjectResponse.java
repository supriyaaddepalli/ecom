/**
 * 
 */
package com.abc.ecom.exception;

import org.springframework.stereotype.Component;

/**
 * @author supriya
 * date - 10-Jul-2021
 */
@Component
public class ObjectResponse {

	private String message;
	private int status;
	/**
	 * This method is to get message
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * This method is to set message
	 * @param message 
	 */
	public void setMessage(String message) {
		this.message = message;
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
