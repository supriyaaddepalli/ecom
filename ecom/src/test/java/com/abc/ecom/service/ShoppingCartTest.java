package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.CartItem;
import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.ShoppingCart;
import com.abc.ecom.repository.ShoppingCartRepository;

/**
 * @author admin1
 *
 *         date: 09-July-2021
 */
@SpringBootTest
public class ShoppingCartTest {

	@Mock
	private ShoppingCartRepository shopingCartRepository;

	@InjectMocks
	private ShoppingCartServiceImpl shoppingCartServiceImpl;

	@Test
	public void testsaveShoppingCart() {

		Customer customer = new Customer();
		customer.setCustomerId(2);
		CartItem item1 = new CartItem();
		item1.setCartItemid(1);
		item1.setQuantity(2);
		CartItem item2 = new CartItem();
		item2.setCartItemid(2);
		item2.setQuantity(1);
		List<CartItem> list = new ArrayList<>();
		list.add(item1);
		list.add(item2);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCartId(12);
		shoppingCart.setCustomer(customer);
		shoppingCart.setCartItems(list);
		when(shopingCartRepository.save(shoppingCart)).thenReturn(shoppingCart);
		assertEquals(12, shoppingCart.getCartId());
		assertEquals(2, shoppingCart.getCartItems().size());
		assertEquals(2, shoppingCart.getCustomer().getCustomerId());
	}


}