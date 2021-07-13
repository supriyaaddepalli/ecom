package com.abc.ecom.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Rajesh
 *06-Jul-2021
 */
public class ShippingDetailsModel {

	
	private int shippingId;	
	@NotNull(message="please provide a price")
	private double shippingCost;	
	@NotEmpty(message="Specify the type of shipping")
	private String typeOfShipping;	

	
	/**
	 * 
	 * @return shippingId
	 */
	public int getShippingId() {
		return shippingId;
	}
	/**
	 * to set the shippingId
	 * @param shippingId
	 */
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	/**
	 * 
	 * @return shippingCost
	 */
	public double getShippingCost() {
		return shippingCost;
	}
	/**
	 * to set the shippingCost
	 * @param shippingCost
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	/**
	 * 
	 * @return typeOfShipping
	 */
	public String getTypeOfShipping() {
		return typeOfShipping;
	}
	/**
	 * to set the typeOfShipping
	 * @param typeOfShiping
	 */
	public void setTypeOfShipping(String typeOfShipping) {
		this.typeOfShipping = typeOfShipping;
	}
}