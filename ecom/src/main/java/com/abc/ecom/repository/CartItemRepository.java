/**
 * 
 */
package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.CartItem;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
