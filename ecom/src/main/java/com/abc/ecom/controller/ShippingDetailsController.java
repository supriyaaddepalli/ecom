/**
 * 
 */
package com.abc.ecom.controller;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.exception.ObjectResponse;
import com.abc.ecom.model.ShippingDetailsModel;
import com.abc.ecom.service.ShippingDetailsService;

/**
 * @author Rajesh
 *06-Jul-2021
 */
@RestController
@RequestMapping("/shipping")
@Validated
public class ShippingDetailsController {
	
	@Autowired
	private ShippingDetailsService shippingDetailsService;
	@Autowired
	private ObjectResponse objectResponse;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShippingDetailsController.class);
	
	/**
	 * this method will save the shipping details
	 * @param shippingDetailsModel
	 * @param orderId
	 * @return status message
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveShippingDetails(@Valid @RequestBody  ShippingDetailsModel shippingDetailsModel) {
		LOGGER.info("Requested /api/ shipping/save endpoint");	
		shippingDetailsService.saveShippingDetails(shippingDetailsModel);
		LOGGER.info(" ShippingDetails saved");
		objectResponse.setMessage("ShippingDetails Added");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.CREATED);
	}
	
	
	/**
	 * this method will find the shipping by Id
	 * @param shippingId
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> fetchShippingDetailsById(@PathVariable("id") int shippingId) {
	LOGGER.info("Getting the Category with id",shippingId);
	ShippingDetailsModel shippingDetailsModel = shippingDetailsService.fetchShippingDetailsById(shippingId);
	return new ResponseEntity<>(shippingDetailsModel,HttpStatus.OK);	
	}
	
	
	/**
	 * this method will erase shipping details by id
	 * @param shippingDetailsModel
	 * @return
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> deleteShippingDetails(@RequestBody ShippingDetailsModel shippingDetailsModel ){
		LOGGER.info("Requested /api/ ShippingDetails/deleteShippingDetails endpoint");	
		shippingDetailsService.deleteShippingDetails(shippingDetailsModel);
		LOGGER.info("ShippingDetails are deleted");
		objectResponse.setMessage("ShippingDetails deleted");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.CREATED);		
	}
}

