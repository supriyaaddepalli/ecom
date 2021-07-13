package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Product;
/**
 * 
 * @author supriya
 * date - 06-July-2021
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
