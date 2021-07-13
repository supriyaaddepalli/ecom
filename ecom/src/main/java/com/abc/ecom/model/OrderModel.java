package com.abc.ecom.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.abc.ecom.entity.ShippingDetails;

public class OrderModel {
	
	private int orderid;
	private String status;
	private LocalDate dateOfOrder;
	private int totalQuantity;
	private double totalCost;
	private PaymentModel paymentModel;
	private CustomerModel customerModel;
	private ShippingDetails shippingDetails;
	private ShoppingCartModel shoppingCartModel;
	private List<OrderItemModel> orderItemModels = new ArrayList<>();
	
	
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
	 * @return the paymentModel
	 */
	public PaymentModel getPaymentModel() {
		return paymentModel;
	}

	/**
	 * @param paymentModel the paymentModel to set
	 */
	public void setPaymentModel(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
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
	 * @return the customerModel
	 */
	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	/**
	 * @param customerModel the customerModel to set
	 */
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	/**
	 * @return the orderid
	 */
	public int getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	 * @return the orderItemModels
	 */
	public List<OrderItemModel> getOrderItemModels() {
		return orderItemModels;
	}

	/**
	 * @param orderItemModels the orderItemModels to set
	 */
	public void setOrderItemModels(List<OrderItemModel> orderItemModels) {
		this.orderItemModels = orderItemModels;
	}


}
