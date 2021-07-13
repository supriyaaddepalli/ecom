package com.abc.ecom.payload;

import java.util.ArrayList;
import java.util.List;

import com.abc.ecom.model.CartItemModel;
import com.abc.ecom.model.ShoppingCartModel;

public class CartPayLoad {
	
	private ShoppingCartModel shoppingCartModel;	
	private int customerId;	
	private List<CartItemModel> cartItemModel = new ArrayList<>();	
	private int cartId;



	/**
	 * @return the shoppingCartModel
	 */
	public ShoppingCartModel getShoppingCartModel() {
		return shoppingCartModel;
	}

	/**
	 * @param shoppingCartModel the shoppingCartModel to set
	 */
	public void setShoppingCartModel(ShoppingCartModel shoppingCartModel) {
		this.shoppingCartModel = shoppingCartModel;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the cartItemModel
	 */
	public List<CartItemModel> getCartItemModel() {
		return cartItemModel;
	}

	/**
	 * @param cartItemModel the cartItemModel to set
	 */
	public void setCartItemModel(List<CartItemModel> cartItemModel) {
		this.cartItemModel = cartItemModel;
	}

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

}
