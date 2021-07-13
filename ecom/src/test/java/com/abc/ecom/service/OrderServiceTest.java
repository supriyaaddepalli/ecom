/**
 * 
 */
package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.ecom.entity.Order;
import com.abc.ecom.repository.OrderRepository;

/**
 * @author supriya
 * date - 11-Jul-2021
 */
@SpringBootTest
public class OrderServiceTest {
	
	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private OrderServiceImpl orderServiceImpl;

	@Test
	public void createOrder() {
		Order order = new Order();
		order.setOrderId(1);
		order.setDateOfOrder(LocalDate.now());
		order.setTotalQuantity(2);
		order.setTotalCost(7000);
		order.setShippingCost(770);
	
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(1, order.getOrderId());
		assertEquals(2, order.getTotalQuantity());
		assertEquals(7000, order.getTotalCost());
	}
	@Test
	public void testStatus() {
		
		Order order = new Order();
		order.setStatus("fail");
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals("fail", order.getStatus());		
		}
}
