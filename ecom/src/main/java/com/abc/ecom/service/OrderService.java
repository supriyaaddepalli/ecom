/**
 * 
 */
package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Order;
import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
public interface OrderService {
	/**
	 * This mehtod is delete orderbyId
	 * @param orderId
	 */
	public void deleteOrderById(int orderId) throws ResourceAlreadyExistException;
	/**
	 * This method is get All orders
	 * @return
	 */
	public List<Order> getAllOrders() throws ResourceNotFoundException;
	/**
	 * This method is to create order
	 * @param shoppingCartId
	 * @param shippingId
	 * @param paymentAmount
	 */
	public void createOrder(int shoppingCartId , int shippingId ,double paymentAmount) throws ResourceNotFoundException;
	/**
	 * This method is to know the orderStatus
	 * @param orderId
	 * @return
	 */
	public String orderStatus(int orderId) throws ResourceNotFoundException;

}
