package com.abc.ecom.exception;
/**
 * 
 * @author supriya
 * date - 05-Jul-2021
 */
public class ResourceAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * THis method is to handle ResourceAlreadyExistException
	 * @param msg
	 */
	public ResourceAlreadyExistException(String msg) {
		super(msg);
	}
	

}
