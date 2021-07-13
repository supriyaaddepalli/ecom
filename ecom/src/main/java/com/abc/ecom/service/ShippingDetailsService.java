package com.abc.ecom.service;

import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ShippingDetailsModel;

/**
 * @author Rajesh
 *06-Jul-2021
 */
public interface ShippingDetailsService {
	/**
	 *  This method is to save product to database
	 * @param shippingDetailsModel
	 * @throws ResourceNotFoundException
	 */
	
	 public void saveShippingDetails(ShippingDetailsModel shippingDetailsModel) throws ResourceNotFoundException;
	/**
	 * This method is to find Product based on Id of product
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	 public ShippingDetailsModel fetchShippingDetailsById(int shippungId) throws ResourceNotFoundException;
	 /**
	  * This method is to delete product from database
	  * @param shippingDetailsModel
	  * @throws ResourceNotFoundException
	  */
	 public void deleteShippingDetails(ShippingDetailsModel shippingDetailsModel) throws ResourceNotFoundException;

}

