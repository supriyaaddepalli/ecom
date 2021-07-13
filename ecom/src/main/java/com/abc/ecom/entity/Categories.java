package com.abc.ecom.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author supriya
 * date - 05-July-2021
 */
@Entity
@Table(name = "category_tbl")
public class Categories {
	
	@Id
	@Column(name = "categoryid")
	private int categoryId;
	@Column(name = "categorytype")
	private String categoryType;
	
	@OneToMany(targetEntity =Product.class, cascade =  CascadeType.ALL)
	@JoinColumn(name = "cp_fk" , referencedColumnName = "categoryId")
	private List<Product> products = new ArrayList<>();

	/**
	 * To return CategoryId
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * to set the categoryId
	 * @param categoryId  
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * to get the CategoryType
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
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
