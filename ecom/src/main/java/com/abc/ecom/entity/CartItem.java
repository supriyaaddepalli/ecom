package com.abc.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author supriya
 * date - 07-Jul-2021
 */
@Entity
@Table(name = "cartitem_tbl")
public class CartItem {
	@Id
	@Column(name= "cartitemid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartItemid;
	@Column(name = "quantity")
	private int quantity;
	@OneToOne
	private Product product;
	@ManyToOne
	@JsonBackReference
	private ShoppingCart shoppingCart;

	
	/**
	 * @return the shoppingCart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * @param shoppingCart the shoppingCart to set
	 */
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
	 * @return the cartItemid
	 */
	public int getCartItemid() {
		return cartItemid;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @param cartItemid the cartItemid to set
	 */
	public void setCartItemid(int cartItemid) {
		this.cartItemid = cartItemid;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	

}
