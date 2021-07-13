/**
 * 
 */
package com.abc.ecom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Admin;
import com.abc.ecom.entity.Customer;
import com.abc.ecom.exception.ObjectResponse;
import com.abc.ecom.payload.LoginPayload;
import com.abc.ecom.service.LoginService;

/**
 * @author supriya
 * date - 11-Jul-2021
 */

@RestController
@RequestMapping("/login")
public class LoginController {				
		@Autowired
		private ObjectResponse objectResponse;
		@Autowired
		private LoginService loginService;
		
		private static final Logger LOGGER =LoggerFactory.getLogger(LoginController.class);
		
		
		@PostMapping("/customerStatus")
		public ResponseEntity<?> createLoginforCustomer(@RequestBody LoginPayload loginPayLoad) {
			 LOGGER.info("Path:/login/status");
			 LOGGER.info("login method is started");
			Customer customer = loginService.customerLogin(loginPayLoad.getEmail(),loginPayLoad.getPassword());
		
			if(customer != null) {
			return  new ResponseEntity<>(customer,HttpStatus.OK);
			}
			else {	
				 LOGGER.info("invalid credentials entered in login");
				 objectResponse.setMessage("Invalid Email/password. Please try with correct credentials.");
					objectResponse.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<>(objectResponse,HttpStatus.OK);
				
			}		
	}
		@PostMapping("/adminStatus")	
	    public ResponseEntity<?> createLoginforAdmin(@RequestBody LoginPayload loginPayLoad){
		
		Admin admin = loginService.adminLogin(loginPayLoad.getEmail(),loginPayLoad.getPassword());
		if(admin != null) {
			return new ResponseEntity<>(admin,HttpStatus.OK);
		}
		else {
			 LOGGER.info("invalid credentials entered in login");
			 objectResponse.setMessage("Invalid Email/password. Please try with correct credentials.");
				objectResponse.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<>(objectResponse,HttpStatus.OK);			
		}
	}
	}


