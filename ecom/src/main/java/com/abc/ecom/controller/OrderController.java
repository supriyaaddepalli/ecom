/**
 * 
 */
package com.abc.ecom.controller;

import java.util.List;
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
import com.abc.ecom.payload.OrderPayLoad;
import com.abc.ecom.payload.checkoutPayLoad;
import com.abc.ecom.service.OrderService;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ObjectResponse objectResponse;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	/**
	 * This method is to Add Order
	 * @param checkoutPayLoad
	 * @return ResponseEntity
	 */
	@PostMapping("/saveOrder")
	public ResponseEntity<?> addOrder(@RequestBody @Valid checkoutPayLoad checkoutPayLoad){
		LOGGER.info("Requested /order/saveOrder endpoint.");
		orderService.createOrder(checkoutPayLoad.getCartId(),checkoutPayLoad.getShippingId(),checkoutPayLoad.getPaymentAmount());
		LOGGER.info("Order Created Sucessfully");
		objectResponse.setMessage("Order Created");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
	}
	/**
	 * THis method is to delete Order
	 * @param payload
	 * @return ResponseEntity
	 */
	@PostMapping("/deleteOrder")
	public ResponseEntity<?> cancelOrderById(@RequestBody OrderPayLoad payload){
		LOGGER.info("Requested /order/deleteOrder endpoint.");
		orderService.deleteOrderById(payload.getOrderId());
		LOGGER.info("Order Deleted ");
		objectResponse.setMessage("Order Cancelled");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
	}
	/**
	 * This Method is get All Orders
	 * @return ResponseEntity
	 */
	@GetMapping("/allOrders")
	public ResponseEntity<?> getAllOrders(){
		LOGGER.info("Requested /order/allOrders endpoint.");
		List<com.abc.ecom.entity.Order> order =orderService.getAllOrders();
		LOGGER.info("Order List Obtaind ");
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	/**
	 * This method is to get status of order
	 * @param orderId
	 * @return
	 */
	@GetMapping("/status/{id}")
	public ResponseEntity<?> getOrderStatus(@PathVariable("id") int orderId){
		LOGGER.info("Requested /order/status endpoint.");
		String status =orderService.orderStatus(orderId);
		LOGGER.info("Order status Obtaind ");
		objectResponse.setMessage(status);
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
	}

}
