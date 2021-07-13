/**
 * 
 */
package com.abc.ecom.model;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
public class CartItemModel {
	
	private int cartItemId;
	private int quantity;
	private int productId;
	private ProductModel productModel;
	private ShoppingCartModel shoppingCartModel;
	
	
	/**
	 * @return the productModel
	 */
	public ProductModel getProductModel() {
		return productModel;
	}
	/**
	 * @param productModel the productModel to set
	 */
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	/**
	 * @return the cartItemId
	 */
	public int getCartItemId() {
		return cartItemId;
	}
	/**
	 * @param cartItemId the cartItemId to set
	 */
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
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

}
