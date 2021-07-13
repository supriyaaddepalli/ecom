/**
 * 
 */
package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.OrderItem;

/**
 * @author supriya
 * date - 08-Jul-2021
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	
	
	

}
