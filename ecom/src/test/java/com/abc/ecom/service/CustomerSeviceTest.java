/**
 * 
 */
package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.model.CustomerModel;
import com.abc.ecom.repository.CustomerRepository;

/**
 * @author supriya
 * date - 10-Jul-2021
 */
@SpringBootTest
public class CustomerSeviceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	@Test
	public void testCustomerSave() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("supriya");
		customer.setPhoneNumber(123456);
		customer.setAddress("WestGodavari,andhraPradesh");
		customer.setEmail("supriya@gmail.com");
		
		CustomerModel customerModel = new CustomerModel();
		customerModel.setCustomerId(customer.getCustomerId());
		customerModel.setCustomerName(customer.getCustomerName());
		customerModel.setPhoneNumber(customer.getPhoneNumber());
		customerModel.setAddress(customer.getAddress());
		customerModel.setEmail(customer.getEmail());
		when(customerRepository.save(customer)).thenReturn(customer);
		customerServiceImpl.saveCustomer(customerModel);
		
		assertEquals(1, customer.getCustomerId());
	}
	
	@Test
    public void TestFindCustomerById() {		
       Customer customer=new Customer();
       customer.setCustomerId(100);
		customer.setCustomerName("rami");
		customer.setEmail("ramireddy@gmail.com");
		customer.setAddress("hyd");
		customer.setPassword("AbCd");
        
        Optional<Customer> optionalCustomer = Optional.of(customer);
        when(customerRepository.findById(100)).thenReturn(optionalCustomer);
          assertEquals(100,customer.getCustomerId());
	
	}
	
	
}
