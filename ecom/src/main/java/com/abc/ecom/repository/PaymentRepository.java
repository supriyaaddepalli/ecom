/**
 * 
 */
package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Payment;

/**
 * @author supriya
 * date - 10-Jul-2021
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
