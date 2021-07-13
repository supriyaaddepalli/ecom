/**
 * 
 */
package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Categories;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.CategoriesModel;
import com.abc.ecom.repository.CategoryRepository;

/**
 * @author supriya
 * date - 06-Jul-2021
 */
@SpringBootTest
public class CategoryServiceTest {
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private CategoryServiceImpl coategoryServiceImpl;
	
	@Test
	void testFindCategoryById() {
		Categories categories = new Categories();
		categories.setCategoryId(1000);
		categories.setCategoryType("living");
		
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("LivingChair");
		product.setProductPrice(20000);
		products.add(product);	
		categories.setProducts(products);
		
		Optional<Categories> OptionalCategory = Optional.of(categories);
		when(categoryRepository.findById(1000)).thenReturn(OptionalCategory);
		
		CategoriesModel categoriesModel =coategoryServiceImpl.fetchById(1000); // actual Service from database
		
		assertEquals(categoriesModel.getCategoryId(), categories.getCategoryId());
		assertEquals(categoriesModel.getCategoryType() , categories.getCategoryType());
		
	}
	
	@Test
	 void testCategoryByIdThrowingException() {
		
		when(categoryRepository.findById(1001)).thenThrow(ResourceNotFoundException.class);	
		assertThrows(ResourceNotFoundException.class,()->coategoryServiceImpl.fetchById(1001) );	
	}
	
	@Test
	 void testCategorySave() {
		Categories categories = new Categories();
		categories.setCategoryId(1000);
		categories.setCategoryType("living");
		
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("LivingChair");
		product.setProductPrice(20000);
		products.add(product);	
		categories.setProducts(products);
		
		when(categoryRepository.save(categories)).thenReturn(categories);
		
		assertEquals(1000, categories.getCategoryId());
	}
}