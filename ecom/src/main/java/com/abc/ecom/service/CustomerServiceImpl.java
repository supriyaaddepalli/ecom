package com.abc.ecom.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Customer;

import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.CustomerModel;
import com.abc.ecom.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private Customer convert(CustomerModel customerModel) {
		Customer customer = new Customer();
		customer.setCustomerId(customerModel.getCustomerId());
		customer.setCustomerName(customerModel.getCustomerName());
		customer.setEmail(customerModel.getEmail());
		customer.setAddress(customerModel.getAddress());
		customer.setPassword(customerModel.getPassword());
		customer.setPhoneNumber(customerModel.getPhoneNumber());
		return customer;
	}

	private CustomerModel convert(Optional<Customer> optionalCustomer) {
		CustomerModel customerModel = new CustomerModel();
		customerModel.setCustomerId(optionalCustomer.get().getCustomerId());
		customerModel.setCustomerName(optionalCustomer.get().getCustomerName());
		customerModel.setEmail(optionalCustomer.get().getEmail());
		customerModel.setAddress(optionalCustomer.get().getAddress());
		customerModel.setPhoneNumber(optionalCustomer.get().getPhoneNumber());
		customerModel.setPassword(optionalCustomer.get().getPassword());
		return customerModel; 
	}
	
	/**
	 * Implements Save Customer Details  by id from customer service interface
	 * {@inheritDoc}
	 */
	@Override
	public void saveCustomer(CustomerModel customerModel) throws ResourceAlreadyExistException {
		
		LOGGER.info("customerRepository::findById(int id)method called");
		
		 Optional<Customer> optionalCustomer = customerRepository.findById(customerModel.getCustomerId());
			
			if(optionalCustomer.isPresent()) {
				throw new ResourceAlreadyExistException("customer already existing with id: "+customerModel.getCustomerId());
			}
			Optional<Customer> optionalCustomer1 = customerRepository.findByemail(customerModel.getEmail());
			if(optionalCustomer1.isPresent()){
				throw new ResourceAlreadyExistException("email already registered");
			}
			else {
				Customer customer =convert(customerModel);
				
				customerRepository.save(customer);
				
				LOGGER.info("customer details saved in repository");
			}
	}

	/**
	 * Implements delete Customer Details  by id from customer service interface
	 *  {@inheritDoc}
	 */
	@Override
	public void deleteCustomer(CustomerModel customerModel) throws ResourceNotFoundException {
		
		LOGGER.info("customerRepository::findById method called from CustomerService::deleteCustomerbyId");
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerModel.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("customer not found with id "+customerModel.getCustomerId());
		}
		
		else {
			Customer customer = convert(customerModel);
			customerRepository.delete(customer);
			
			LOGGER.error("ResourceNotFoundException encountered with id " ,customer);
		}
		LOGGER.info("Exiting from CustomerServiceImpl::deleteCustomerbyId(int id)method");
	}

	/**
	 *  Implements fetching the customer details using id from customer service interface
	 *  {@inheritDoc}
	 */	
	@Override
	public CustomerModel fetchById(int customerId) throws ResourceNotFoundException {
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("customer not found with id "+customerId);
		}
		else {
			return convert(optionalCustomer);
		     	
	         }
		
	}

	/**
	 * Implements update customer details by id from customer service interface
	 *  {@inheritDoc}
	 */
	@Override
	public void updateCustomer(CustomerModel customerModel) throws ResourceNotFoundException {
		
		LOGGER.info("customerRepository::findById method called from CustomerService::updateCustomerbyId");
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerModel.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			
			LOGGER.error("ResourceAlreadyExistException with id" +customerModel.getCustomerId());
			
			throw new ResourceNotFoundException("product not found with id "+customerModel.getCustomerId());
		}
		else {			
			LOGGER.info("customer details updated in repository");
			Customer customer = convert(customerModel);
			customerRepository.save(customer);
		}
		
		LOGGER.info("Exiting from CustomerServiceImpl::updateCustomer(Customer customer)method");
	}

}




