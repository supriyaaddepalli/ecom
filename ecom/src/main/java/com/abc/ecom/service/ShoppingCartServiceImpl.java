/**
 * 
 */
package com.abc.ecom.service;

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
import com.abc.ecom.entity.Product;
import com.abc.ecom.entity.ShoppingCart;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.CartItemModel;
import com.abc.ecom.payload.CartPayLoad;
import com.abc.ecom.repository.CartItemRepository;
import com.abc.ecom.repository.CustomerRepository;
import com.abc.ecom.repository.ProductRepository;
import com.abc.ecom.repository.ShoppingCartRepository;

/**
 * @author INDU
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
	
	@Override
	public void saveShoppingCart(CartPayLoad cartPayLoad) {
		LOGGER.info("saveShopping is called");
		Optional<Customer> optionalCustomer =  customerRepository.findById(cartPayLoad.getCustomerId());
		if(optionalCustomer.isEmpty()){
			throw new ResourceNotFoundException("Customer is not found with id "+cartPayLoad.getCustomerId());
		}
		if(optionalCustomer.isPresent()) {
			LOGGER.info("customer is present");
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setCustomer(optionalCustomer.get());
			List<CartItem> cartItems = new ArrayList<>();
			List<CartItemModel> cartItemModel = cartPayLoad.getCartItemModel();		
			Iterator<CartItemModel> i = cartItemModel.iterator();
			while(i.hasNext()) {
				LOGGER.info("iterator is called");
				CartItemModel cartitemModel = i.next();
				CartItem cartItem = new CartItem();
				Optional<Product> optionalProduct = productRepository.findById(cartitemModel.getProductId());
				if(optionalProduct.isPresent()) {
				    cartItem.setProduct(optionalProduct.get());
					cartItem.setQuantity(cartitemModel.getQuantity());
					cartItem.setCartItemid(cartitemModel.getCartItemId());
					LOGGER.info("cartItemrepositry is called");
					cartItemRepository.save(cartItem);
					cartItems.add(cartItem);
				}
				else {
					throw new ResourceNotFoundException("Product is not found with ");
				}				
			}		
			shoppingCart.setCartItems(cartItems);
			shoppingCartRepository.save(shoppingCart);	
			
			Iterator<CartItem> i1 = cartItems.iterator();
			while(i1.hasNext()){
				CartItem cartitem =i1.next();
				cartitem.setShoppingCart(shoppingCart);
				cartItemRepository.save(cartitem);
			}
		}			
	}

	@Override
	public void deleteShoppingCart(int cartId) {
		
		Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);
		if(optionalShoppingCart.isPresent()) {
			shoppingCartRepository.deleteById(cartId);
		}
		else {
			throw new ResourceNotFoundException("order not exist to delete with id "+cartId);		
		}		
	}

}
