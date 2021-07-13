/**
 * 
 */
package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ProductModel;
import com.abc.ecom.repository.ProductRepository;

/**
 * @author supriya
 * date - 06-Jul-2021
 */
@SpringBootTest
public class ProductServiceTest {
	
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Test
	public void testProductFindById() {
		Product product = new Product();
		product.setProductId(100);
		product.setProductName("chair");
		product.setProductPrice(2000);
		
		Optional<Product> optionalProduct = Optional.of(product);
		when(productRepository.findById(100)).thenReturn(optionalProduct);
		assertEquals(100, product.getProductId());	
	}
	
	@Test
	public void testSaveProduct() {
		ProductModel productModel = new ProductModel();
		productModel.setProductId(100);
		productModel.setProductName("chair");
		productModel.setProductPrice(20000);
		
		Product product = new Product();
		product.setProductId(productModel.getProductId());
		product.setProductName(productModel.getProductName());
		product.setProductPrice(productModel.getProductPrice());	
		when(productRepository.save(product)).thenReturn(product);
		productServiceImpl.saveProduct(productModel);
		assertEquals(100, product.getProductId());
	}
	
	@Test
	public void testProductByIdThrowsResourceNotFoundException() {
		when(productRepository.findById(1001)).thenThrow(ResourceNotFoundException.class);	
		assertThrows(ResourceNotFoundException.class,()->productServiceImpl.fetchById(1001) );
	}
	

}
