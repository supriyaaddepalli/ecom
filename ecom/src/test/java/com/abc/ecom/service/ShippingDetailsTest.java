/**
 * 
 */
package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.ShippingDetails;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ShippingDetailsModel;
import com.abc.ecom.repository.ShippingDetailsRepository;

/**
 * @author Rajesh
 *08-Jul-2021
 */
@SpringBootTest
public class ShippingDetailsTest {
	
	@Mock
	private ShippingDetailsRepository shippingDetailsRepository;
	
	@InjectMocks
	private ShippingDetailsServiceImpl shippingDetailsServiceImpl;
	/**
	 *This method is to test the ShippingDetals FetchBy Id
	 */
	@Test
	public void testShippingDetailsFetchById() {
		
		ShippingDetails shippingDetails = new ShippingDetails();
		shippingDetails.setShippingId(1);
		shippingDetails.setShippingCost(200);
		shippingDetails.setTypeOfShipping("Normal");
		
		Optional<ShippingDetails> optionalShippingDetails =Optional.of(shippingDetails);
		when(shippingDetailsRepository.findById(1)).thenReturn(optionalShippingDetails);
	}
	/**
	 *This method is to test saveSipping Details
	 */
	@Test
	public void testsaveSippingDetails() {
		ShippingDetailsModel shippingDetailsModel = new ShippingDetailsModel();
		//shippingDetailsModel.setOrderModel(null);
		shippingDetailsModel.setShippingId(12);
		shippingDetailsModel.setShippingCost(200);
		shippingDetailsModel.setTypeOfShipping("express");
		
		shippingDetailsServiceImpl.saveShippingDetails(shippingDetailsModel);
	}
//	/**
//	 *This method is to test Delete Shipping Details
//	 */
//	@Test
//	public void testDeleteShippingDetails() {
//		ShippingDetailsModel shippingDetailsModel = new ShippingDetailsModel();
//		shippingDetailsModel.setShippingCost(500);
//		shippingDetailsModel.setShippingId(11);
//		shippingDetailsModel.setTypeOfShipping("normal");
//		
//		shippingDetailsServiceImpl.deleteShippingDetails(shippingDetailsModel);
//	
//
//}
	/**
	 *This method is to test Resource Not Found Exception
	 */
	@Test
	public void testResourceNotFoundException() {
		when(shippingDetailsRepository.findById(20)).thenThrow(ResourceNotFoundException.class);
		
		assertThrows(ResourceNotFoundException.class,()->shippingDetailsServiceImpl.fetchShippingDetailsById(20));
	}
	/**
	 * This method is to test Resource Already ExistException
	 */
	@Test
	public void testResourceAlreadyExistException() {
		when(shippingDetailsRepository.findById(21)).thenThrow(com.abc.ecom.exception.ResourceAlreadyExistException.class);
		
		assertThrows(com.abc.ecom.exception.ResourceAlreadyExistException.class,()->shippingDetailsServiceImpl.fetchShippingDetailsById(21));
	}
}
