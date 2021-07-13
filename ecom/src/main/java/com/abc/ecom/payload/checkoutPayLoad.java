/**
 * 
 */
package com.abc.ecom.payload;

/**
 * @author supriya
 * date - 10-Jul-2021
 */
public class checkoutPayLoad {
	
	private int cartId;	
	private double paymentAmount;
	private int shippingId;

	/**
	 * @return the shippingId
	 */
	public int getShippingId() {
		return shippingId;
	}

	/**
	 * @param shippingId the shippingId to set
	 */
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
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

	/**
	 * @return the paymentAmount
	 */
	public double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	

}
