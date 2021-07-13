package com.abc.ecom.model;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;


/**
 * 
 * @author kajal Udgire
 *
 */
public class PaymentModel {
	
	private int paymentId;
	@NotEmpty(message="please provide payment type")
	private String paymentType;
	private double amount;
	@NotEmpty(message="please provide payment date")
	private LocalDate dateOfPayment;
	
	
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the dateOfPayment
	 */
	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}
	/**
	 * @param dateOfPayment the dateOfPayment to set
	 */
	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	

}
