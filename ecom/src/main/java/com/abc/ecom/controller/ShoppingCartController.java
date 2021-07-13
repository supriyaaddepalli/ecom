package com.abc.ecom.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.exception.ObjectResponse;
import com.abc.ecom.payload.CartPayLoad;
import com.abc.ecom.service.ShoppingCartService;
/**
 * 
 * @author supriya
 * date - 10-July-2021
 */
@RestController
@RequestMapping("/ShoppingCart")
@Validated
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ObjectResponse objectResponse;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);
	
	@PostMapping("/save")
	public ResponseEntity<?> addShoppingCart(@RequestBody @Valid CartPayLoad cartPayLoad){
		LOGGER.info("Requested /ShoppingCart/save endpoint.");
		shoppingCartService.saveShoppingCart(cartPayLoad);
		LOGGER.info("Cart Created Sucessfully");
		objectResponse.setMessage("Product added to Cart");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.CREATED);		
	}
	
	@PostMapping("/remove")
	public ResponseEntity<?> removeFromCart(@RequestBody CartPayLoad cartPayLoad){
		LOGGER.info("Requested /ShoppingCart/remove endpoint.");
		shoppingCartService.deleteShoppingCart(cartPayLoad.getCartId());
		LOGGER.info("Cart Deleted");
		objectResponse.setMessage("Product removed from Cart");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
		
	}
}
