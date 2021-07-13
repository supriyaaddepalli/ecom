package com.abc.ecom.exception;

/**
 * @author supriya
 * date - 05-Jul-2021
 */
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * THis method is to handle ResourceNotFoundException
	 * @param msg
	 */
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
