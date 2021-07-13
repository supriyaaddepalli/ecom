/**
 * 
 */
package com.abc.ecom.service;

import com.abc.ecom.payload.CartPayLoad;

/**
 * @author Rajesh
 *
 */
public interface ShoppingCartService {
	
	public void saveShoppingCart(CartPayLoad cartPayLoad);
	
	public void deleteShoppingCart(int cartID);

}
