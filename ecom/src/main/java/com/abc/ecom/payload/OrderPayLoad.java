/**
 * 
 */
package com.abc.ecom.payload;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.abc.ecom.model.OrderItemModel;
import com.abc.ecom.model.OrderModel;

/**
 * @author supriya
 * date - 08-Jul-2021
 */
public class OrderPayLoad {
	
	private int orderId;
	private OrderModel orderModel;
	@NotNull(message = "customer id shouls be given")
	private int customerId;	
	private List<OrderItemModel> orderItemModels = new ArrayList<>();
	private String status;
	@NotNull(message ="shipping id should be there")
	private int shippingId;
	
	
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
	 * @return the orderModel
	 */
	public OrderModel getOrderModel() {
		return orderModel;
	}

	/**
	 * @param orderModel the orderModel to set
	 */
	public void setOrderModel(OrderModel orderModel) {
		this.orderModel = orderModel;
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
	
	
	



}
