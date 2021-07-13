/**
 * 
 */
package com.abc.ecom.payload;

import javax.validation.constraints.NotEmpty;

/**
 * @author supriya
 * date - 11-Jul-2021
 */
public class LoginPayload {
	
	@NotEmpty(message="enter email")
	private String email;
	@NotEmpty(message="enter password")
	private String password;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
