package com.abc.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Categories;
/**
 * 
 * @author supriya
 * date - 05-Jul-2021
 */
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
	
	/**
	 * 
	 * @param categoryType
	 * @return
	 */
	public Optional<Categories> findBycategoryType(String categoryType);
	
}
