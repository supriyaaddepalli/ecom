/**
 * 
 */
package com.abc.ecom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Admin;
import com.abc.ecom.entity.Customer;
import com.abc.ecom.repository.AdminRepository;
import com.abc.ecom.repository.CustomerRepository;

/**
 * @author supriya
 * date - 11-Jul-2021
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	private static final Logger LOGGER =LoggerFactory.getLogger(LoginServiceImpl.class);
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public Customer customerLogin(String customerEmail, String customerPassword) {
		 LOGGER.info("Fetching customer Id for the login is started.");
	       Customer customer = customerRepository.customerLogin(customerEmail, customerPassword);	
			
	       LOGGER.info("Login is successful.");
			return customer;
	}
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public Admin adminLogin(String adminEmail, String adminPassword) {
		 LOGGER.info("Fetching customer Id for the login is started.");
		Admin admin = adminRepository.adminLogin(adminEmail, adminPassword);
		  LOGGER.info("Login is successful.");
		return admin;
	}

}
