/**
 * 
 */
package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Order;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	
}
