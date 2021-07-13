/**
 * 
 */
package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.ShoppingCart;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{

}
