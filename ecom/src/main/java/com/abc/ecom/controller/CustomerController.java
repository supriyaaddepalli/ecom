package com.abc.ecom.controller;
/**
 * 
 */

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.model.CustomerModel;
import com.abc.ecom.service.CustomerService;
/**
 * 
 * @author ramireddy
 * date - 12-Jul-2021
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
	

	@Autowired
	private CustomerService customerService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/save")
	public ResponseEntity<?> addCustomer( @Valid @RequestBody  CustomerModel customerModel){
		LOGGER.info("Requested /api/customer/saveCustomer endpoint");
		customerService.saveCustomer(customerModel);
		LOGGER.info("Customer added sucessfully");
		return new ResponseEntity<>("Customer Added ",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> removeCustomer(@RequestBody CustomerModel customerModel ){
		LOGGER.info("Requested /api/customer/removeCustomer endpoint");
		customerService.deleteCustomer(customerModel);
		LOGGER.info("Customer removed sucessfully");
		return new ResponseEntity<>("removed sucessfully",HttpStatus.OK);
	}
	
	@PostMapping("/findById")
	public ResponseEntity<?> findById(@RequestBody CustomerModel customerModel ){
		
		CustomerModel customerModel1 =customerService.fetchById(customerModel.getCustomerId());
		return new ResponseEntity<>(customerModel1,HttpStatus.OK);	
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerModel customerModel){
		customerService.updateCustomer(customerModel);
		return new ResponseEntity<>("updated Sucessfully",HttpStatus.OK);
	}

}
