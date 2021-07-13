package com.abc.ecom.model;


public class OrderItemModel {
	
	private int orderItemId;
	private int productQuantity;
	private ProductModel productModel;
	private OrderModel orderModel;
	
	
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
	 * @return the orderItemId
	 */
	public int getOrderItemId() {
		return orderItemId;
	}
	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}
	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
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

	
	
	
}
