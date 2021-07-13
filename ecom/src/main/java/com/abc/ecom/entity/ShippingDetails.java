package com.abc.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author supriya
 * date - 10-Jul-2021
 */
@Entity
@Table(name = "shippingdetails_tbl")
public class ShippingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shippingid")
	private int shippingId;	
	@Column(name = "shippingcost")
	private double shippingCost;
	@Column(name = "typeofshipping")
	private String typeOfShipping;

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
	 * @return the shippingCost
	 */
	public double getShippingCost() {
		return shippingCost;
	}

	/**
	 * @param shippingCost the shippingCost to set
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * @return the typeOfShipping
	 */
	public String getTypeOfShipping() {
		return typeOfShipping;
	}

	/**
	 * @param typeOfShipping the typeOfShipping to set
	 */
	public void setTypeOfShipping(String typeOfShipping) {
		this.typeOfShipping = typeOfShipping;
	}
	
}
