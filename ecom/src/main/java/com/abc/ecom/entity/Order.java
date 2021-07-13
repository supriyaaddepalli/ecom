package com.abc.ecom.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author supriya
 * date - 06-July-2021
 */
@Entity
@Table(name = "order_tbl")
public class Order {
	
	@Id
	@Column(name = "orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@OneToOne
	private Customer customer;
	@Column(name = "dateoforder")
	private LocalDate dateOfOrder;
	@Column(name = "status")
	private String status;
	@Column(name = "totalQuantity")
	private int totalQuantity;
	@Column(name = "cost")
	private double cost;
	@Column(name ="shippingCost")
	private double shippingCost;
	@Column(name ="totalCost")
	private double totalCost;
	@OneToOne
	private Payment payment;
	@OneToOne
	private ShippingDetails shippingDetails;
	@OneToOne
	private ShippingInfo shippingInfo;
	@OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	/**
	 * @return the shippingInfo
	 */
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	/**
	 * @param shippingInfo the shippingInfo to set
	 */
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the dateOfOrder
	 */
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	/**
	 * @param dateOfOrder the dateOfOrder to set
	 */
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the totalQuantity
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
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
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the shippingDetails
	 */
	public ShippingDetails getShippingDetails() {
		return shippingDetails;
	}

	/**
	 * @param shippingDetails the shippingDetails to set
	 */
	public void setShippingDetails(ShippingDetails shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

	

}
