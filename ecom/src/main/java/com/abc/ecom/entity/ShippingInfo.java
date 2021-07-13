/**
 * 
 */
package com.abc.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author supriya
 * date - 10-Jul-2021
 */
@Entity
@Table(name ="shippingInfo_tbl")
public class ShippingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="shippinginfo_id")
	private int shippingInfoId;
	@Column(name ="shippingaddress")
	private String shippingAddress;
	@Column(name ="totalcost")
	private double cost;
	
	
	/**
	 * @return the shippingInfoId
	 */
	public int getShippingInfoId() {
		return shippingInfoId;
	}
	/**
	 * @param shippingInfoId the shippingInfoId to set
	 */
	public void setShippingInfoId(int shippingInfoId) {
		this.shippingInfoId = shippingInfoId;
	}
	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
