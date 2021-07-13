/**
 * 
 */
package com.abc.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.ecom.entity.Customer;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	

	@Query("SELECT c FROM Customer c WHERE email = ?1 AND password = ?2")
	public Customer customerLogin(String customerEmail, String customerPassword);
	
	@Query("SELECT c FROM Customer c WHERE email = ?1")
	public Customer emailCheck(String customerEmail);
	

	public Optional<Customer> findByemail(String customerEmail);
}
