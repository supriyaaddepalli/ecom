/**
 * 
 */
package com.abc.ecom.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.CartItem;
import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Order;
import com.abc.ecom.entity.OrderItem;
import com.abc.ecom.entity.Payment;
import com.abc.ecom.entity.Product;
import com.abc.ecom.entity.ShippingDetails;
import com.abc.ecom.entity.ShippingInfo;
import com.abc.ecom.entity.ShoppingCart;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.CartItemRepository;
import com.abc.ecom.repository.OrderItemRepository;
import com.abc.ecom.repository.OrderRepository;
import com.abc.ecom.repository.PaymentRepository;
import com.abc.ecom.repository.ShippingDetailsRepository;
import com.abc.ecom.repository.ShippingInfoRepository;
import com.abc.ecom.repository.ShoppingCartRepository;

@Service
public class OrderServiceImpl implements OrderService{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;	
	@Autowired
	private PaymentRepository paymentRespoitory;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ShippingInfoRepository shippingInfoRepository;
	@Autowired
	private ShippingDetailsRepository shippingDetailsRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	/**
	 * 
	 *  {@inheritDoc}
	 */
	@Override
	public void createOrder(int shoppingCartId , int shippingId ,double paymentAmount) {
		LOGGER.info("create order method is called");
		Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(shoppingCartId);
		if(optionalShoppingCart.isEmpty()) {
			LOGGER.info("ResourceNotFoundException is thrown as shoppingcart is not found with ID");
			throw new ResourceNotFoundException("cart not found with id "+shoppingCartId);
		}
		Optional<ShippingDetails> shippingDetails = shippingDetailsRepository.findById(shippingId);
		if(shippingDetails.isEmpty()) {
			throw new ResourceNotFoundException("Please provide valid shipping id");
		}
		
		ShoppingCart shoppingCart = optionalShoppingCart.get();
		Customer customer =shoppingCart.getCustomer();
		
		List<CartItem> cartItems = shoppingCart.getCartItems();
		if(cartItems.isEmpty())
			throw new ResourceNotFoundException("Please add atleast one item to order");
		Order order = new Order();
		List<OrderItem> orderitems = new ArrayList<>();

		double cost=0;
		double totalCost=0;
		int totalQuantity=0;
		Iterator<CartItem> it = cartItems.iterator();
		while(it.hasNext()) {
			LOGGER.info("itrator is called");
			CartItem cartItem = it.next();
			OrderItem orderItem = new OrderItem();
			Product product = cartItem.getProduct();
			orderItem.setProduct(product);
			LOGGER.info("quantity of product"+cartItem.getQuantity());
			cost=cost+((cartItem.getQuantity())*(product.getProductPrice()));
			totalQuantity=totalQuantity+(cartItem.getQuantity());
			orderItem.setProductQuantity(cartItem.getQuantity());
			orderitems.add(orderItem);
				
		}
		
		Payment payment = new Payment();
		payment.setAmount(paymentAmount);
		LOGGER.info("payment amount"+paymentAmount);
		if(paymentAmount>=cost) {
			LOGGER.info("payment amount"+paymentAmount);
			payment.setPaymentStatus("sucess");
			payment.setDateOfPayment(LocalDate.now());
			order.setStatus("sucess");
			order.setShippingDetails(shippingDetails.get());
			order.setShippingCost(shippingDetails.get().getShippingCost());
			totalCost=cost+shippingDetails.get().getShippingCost();
			order.setTotalCost(totalCost);
			ShippingInfo shippingInfo = new ShippingInfo();
			LOGGER.info("shippingInfo is called");
			shippingInfo.setShippingAddress(customer.getAddress());
			shippingInfo.setCost(totalCost);
			shippingInfoRepository.save(shippingInfo);
			order.setShippingInfo(shippingInfo);
		}
		else {
			payment.setPaymentStatus("fail");
			order.setStatus("fail");
			order.setShippingDetails(null);
		}
		paymentRespoitory.save(payment);
		order.setTotalCost(totalCost);
		order.setCost(cost);
		order.setTotalQuantity(totalQuantity);
		order.setDateOfOrder(LocalDate.now());
		order.setOrderItems(orderitems);
		order.setPayment(payment);
		order.setCustomer(customer);		
		orderRepository.save(order);	
		Iterator<OrderItem> it1= orderitems.iterator();
		while(it1.hasNext()) {
			OrderItem orderItems=it1.next();
			orderItems.setOrder(order);
			orderItemRepository.save(orderItems);
		}
		shoppingCartRepository.delete(shoppingCart);
		cartItemRepository.deleteAllInBatch(cartItems);
		LOGGER.info("cartItems deleted");
	}
	
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public void deleteOrderById(int orderId) {
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isPresent()) {
			orderRepository.deleteById(orderId);
		}
		
		else {
			throw new ResourceNotFoundException("order not exist to delete with id "+orderId);
		}
	}

	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public List<Order> getAllOrders() {
		List<Order> orderlist = orderRepository.findAll();
		if(orderlist.isEmpty()) {
			throw new ResourceNotFoundException("Order list is empty");
		}
		else {
		return orderlist;
		}
	}


	/**
	 *  {@inheritDoc}
	 */
	@Override
	public String orderStatus(int orderId) {
		String status="";
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isPresent()) {
			Order order=optionalOrder.get();
			status = order.getStatus();
			return status;
		}
		else {
			throw new ResourceNotFoundException("order is not found with given id");
		}				
	}	
	}


