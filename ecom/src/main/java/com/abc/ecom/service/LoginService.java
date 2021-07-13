/**
 * 
 */
package com.abc.ecom.service;

import com.abc.ecom.entity.Admin;
import com.abc.ecom.entity.Customer;

/**
 * @author supriya
 * date - 11-Jul-2021
 */
public interface LoginService {
	
	 public Customer customerLogin(String customerEmail, String customerPassword);
	 
	 public Admin adminLogin(String adminEmail,String adminPassword);

}
