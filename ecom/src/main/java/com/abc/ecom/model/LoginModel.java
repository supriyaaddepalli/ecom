/**
 * 
 */
package com.abc.ecom.model;

import javax.validation.constraints.NotEmpty;

/**
 * @author supriya
 * date - 11-Jul-2021
 */
public class LoginModel {
	
	private int loginId;
	@NotEmpty(message ="enter name")
	private String name;
	@NotEmpty(message="enter passwowrd")
	private String password;
	/**
	 * @return the loginId
	 */
	public int getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
