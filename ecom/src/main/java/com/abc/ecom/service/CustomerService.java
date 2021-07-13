package com.abc.ecom.service;

import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.CustomerModel;

public interface CustomerService {
	
	/**
	 * This method is to save customer to database
	 * @param customerModel
	 * @throws ResourceAlreadyExistException
	 */
	public void saveCustomer(CustomerModel customerModel)throws ResourceAlreadyExistException;
	
	/**
	 * This method is to delete customer from database
	 * @param customerModel
	 * @throws ResourceNotFoundException
	 */
	public void deleteCustomer(CustomerModel customerModel)throws ResourceNotFoundException;
	
	/**
	 * This method is to find customer based on Id of product
	 * @param customerId
	 * @throws ResourceNotFoundException
	 */
	public CustomerModel fetchById(int customerId) throws ResourceNotFoundException;
	
	/**
	 * This method is to Update the customer inside dataBase
	 * @param customerModel
	 * @throws ResourceNotFoundException
	 */
	public void updateCustomer(CustomerModel customerModel)throws ResourceNotFoundException;
	
	
	

}
