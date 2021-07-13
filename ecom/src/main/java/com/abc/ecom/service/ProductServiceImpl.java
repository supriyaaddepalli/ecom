package com.abc.ecom.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.controller.ProductController;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ProductModel;
import com.abc.ecom.repository.ProductRepository;
/**
 * 
 * @author supriya
 * date - 05-Jul-2021
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	/**
	 * This method is just to convert from productModel to product
	 * @param productModel
	 * @return
	 */
	private Product convert(ProductModel productModel) {
		LOGGER.info("covert method is called to convert productModel to product");
		Product product = new Product();
		product.setProductId(productModel.getProductId());
		product.setProductName(productModel.getProductName());
		product.setProductPrice(productModel.getProductPrice());
		LOGGER.info("product returned from convert Method");
		return product;
	}
	/**
	 * This method is just to convert from product to productModel
	 * @param optionalProduct
	 * @return
	 */
	private ProductModel convert(Optional<Product> optionalProduct) {
		LOGGER.info("covert method is called to convert product to productModel");
		ProductModel productModel = new ProductModel();
		productModel.setProductId(optionalProduct.get().getProductId());
		productModel.setProductName(optionalProduct.get().getProductName());
		productModel.setProductPrice(optionalProduct.get().getProductPrice());
		LOGGER.info("productModel returned from convert Method");
		return productModel;
	}
	/**
	 * 
	 *  {@inheritDoc}
	 */
	@Override
	public void saveProduct(ProductModel productModel) throws ResourceAlreadyExistException {
		LOGGER.info("findById() method is called from productRepository in saveproduct method");
		Optional<Product> optionalProduct = productRepository.findById(productModel.getProductId());
		if(optionalProduct.isPresent()) {
			LOGGER.error("ResourceAlreadyExistException is thrown with productid ", productModel.getProductId());
			throw new ResourceAlreadyExistException("product already found with id "+productModel.getProductId());
		}
		else {
		Product product = convert(productModel);
		LOGGER.info("Product saved with productId "+productModel.getProductId());
		productRepository.save(product);	
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public void deleteProduct(int productId) throws ResourceNotFoundException {
		LOGGER.info("findById() method is called from productRepository in deleteProduct Method");
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			LOGGER.error("ResourceNotFoundException is thrown in deleteProduct method with productid ",productId);
			throw new ResourceNotFoundException("product not found to delete with id "+productId);
		}
		else {
		LOGGER.info("Product deleted with productId "+productId);
		//productRepository.delete(optionalProduct.get());
		productRepository.deleteById(productId);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public ProductModel fetchById(int productId) throws ResourceNotFoundException {
		LOGGER.info("findById() method is called from productRepository in fetchById method");
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			LOGGER.error("ResourceNotFoundException is thrown in fetchById method with productid ",productId);
			throw new ResourceNotFoundException("product not found with id "+productId);
		}
		else {
		ProductModel productModel = convert(optionalProduct);
		LOGGER.info("ProductModel is returned in fetchById Method");
		return productModel;
	}
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public void updateProduct(ProductModel productModel) throws ResourceNotFoundException {
		LOGGER.info("findById() method is called from productRepository in updateproduct method");
		Optional<Product> optionalProduct = productRepository.findById(productModel.getProductId());
		if(optionalProduct.isEmpty()) {
			LOGGER.error("ResourceNotFoundException is thrown with productid ", productModel.getProductId());
			throw new ResourceNotFoundException("product not found to update with id "+productModel.getProductId());
		}
		else {
		Product product = convert(productModel);
		LOGGER.info("Product updated with productId "+productModel.getProductId());
		productRepository.save(product);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public List<ProductModel> findAllProducts() throws ResourceNotFoundException {
		LOGGER.info("findAll() method is called from productRepository in findAllProducts method");
		List<Product> listOfProducts = productRepository.findAll();
		List<ProductModel> productModels = new ArrayList<>();
		if(listOfProducts.isEmpty()) {	
			LOGGER.error("ResourceNotFoundException is thrown");
			throw new ResourceNotFoundException("does not contain any product");
		}
		else {
			
			Iterator<Product> i = listOfProducts.iterator();
			while(i.hasNext()) {
				ProductModel productModel = new ProductModel();
				Product product = i.next();
				productModel.setProductId(product.getProductId());
				productModel.setProductName(product.getProductName());
				productModel.setProductPrice(product.getProductPrice());
				productModels.add(productModel);
			}
			LOGGER.info("ProductModel is returned in findAllProducts method");
			return productModels;
		}
		
	}


}
