package com.abc.ecom.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class CategoriesModel {
	
	private int categoryId;
	@NotEmpty(message = "categoryType Required")
	private String categoryType;
	
	@NotEmpty(message ="category contain atleast one product")
	private List<ProductModel> productModels = new ArrayList<>();

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType the categoryType to set
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	/**
	 * @return the productModels
	 */
	public List<ProductModel> getProductModels() {
		return productModels;
	}

	/**
	 * @param productModels the productModels to set
	 */
	public void setProductModels(List<ProductModel> productModels) {
		this.productModels = productModels;
	}

	
	

}
