package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ProductModel;
/**
 * 
 * @author supriya
 * date - 05-July-2021
 */
public interface ProductService {
	
	/**
	 * This method is to save product to database
	 * @param productModel
	 * @throws ResourceAlreadyExistException
	 */
	public void saveProduct(ProductModel productModel)throws ResourceAlreadyExistException;
	
	/**
	 * This method is to delete product from database
	 * @param productModel
	 * @throws ResourceNotFoundException
	 */
	public void deleteProduct(int productId)throws ResourceNotFoundException;
	
	/**
	 * This method is to find Product based on Id of product
	 * @param productId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ProductModel fetchById(int productId) throws ResourceNotFoundException;
	
	/**
	 * This method is to Update the product inside dataBase
	 * @param productModel
	 * @throws ResourceNotFoundException
	 */
	public void updateProduct(ProductModel productModel)throws ResourceNotFoundException;
	
	/**
	 * This method is to get list of all Products
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public List<ProductModel> findAllProducts() throws ResourceNotFoundException ;

}
