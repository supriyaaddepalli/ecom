/**
 * 
 */
package com.abc.ecom.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.ShippingDetails;
import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ShippingDetailsModel;

import com.abc.ecom.repository.ShippingDetailsRepository;

/**
 * @author RAJESH
 *06-Jul-2021
 */
@Service
public class ShippingDetailsServiceImpl implements ShippingDetailsService {
	
	@Autowired
	private ShippingDetailsRepository shippingDetailsRepository;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShippingDetailsServiceImpl.class);

private ShippingDetailsModel convert(Optional<ShippingDetails> optionalShippingDetails) {		
		ShippingDetailsModel shippingDetailsModel = new ShippingDetailsModel();
		shippingDetailsModel.setShippingId(optionalShippingDetails.get().getShippingId());
		shippingDetailsModel.setShippingCost(optionalShippingDetails.get().getShippingCost());
		shippingDetailsModel.setTypeOfShipping(optionalShippingDetails.get().getTypeOfShipping());		
		return shippingDetailsModel;
	}

private ShippingDetails convert(ShippingDetailsModel shippingDetailsModel) {
	ShippingDetails shippingDetails = new ShippingDetails();
	shippingDetails.setShippingId(shippingDetailsModel.getShippingId());
	shippingDetails.setShippingCost(shippingDetailsModel.getShippingCost());
	shippingDetails.setTypeOfShipping(shippingDetailsModel.getTypeOfShipping());
	return shippingDetails;	
}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveShippingDetails(ShippingDetailsModel shippingDetailsModel)throws ResourceNotFoundException {
		LOGGER.info("ShippingDetailsServiceImpl :: saveShippingDetails(ShippingDetailsModel shippingDetailsModel) method is called.");
		Optional<ShippingDetails> optionalShippingDetails = shippingDetailsRepository.findById(shippingDetailsModel.getShippingId());
		
		if(optionalShippingDetails.isPresent()) {
			LOGGER.error("ResourceAlreadyExistException with id"+shippingDetailsModel.getShippingId());
			throw new ResourceAlreadyExistException("ShippingDetails already exist with id "+shippingDetailsModel.getShippingId());
		}
		else {
			
				ShippingDetails shippingDetails = convert(shippingDetailsModel);
				shippingDetailsRepository.save(shippingDetails);			
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ShippingDetailsModel fetchShippingDetailsById(int shippingId) throws ResourceNotFoundException {
		LOGGER.info("ShippingDetailsServiceImpl :: fetchShippingDetailsById(int shippingId) method is called.");
Optional<ShippingDetails> optionalShippingDetails= shippingDetailsRepository.findById(shippingId);
		
		if(optionalShippingDetails.isEmpty()) {
			LOGGER.error("ResourceNotFoundException with id",+shippingId);
			throw new ResourceNotFoundException("ShippingDetails not found with id "+shippingId);
		}
		else {
			ShippingDetailsModel shippingDetailsModel = convert(optionalShippingDetails);
			return shippingDetailsModel;
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteShippingDetails(ShippingDetailsModel shippingDetailsModel) throws ResourceNotFoundException {
		LOGGER.info("ShippingDetailsServiceImpl :: deleteShippingDetails(ShippingDetailsModel shippingDetailsModel) method is called.");
Optional<ShippingDetails> optionalShippingDetails = shippingDetailsRepository.findById(shippingDetailsModel.getShippingId());
		
		if(optionalShippingDetails.isEmpty()) {
			LOGGER.error("ResourceNotFoundException with id"+shippingDetailsModel.getShippingId());
			throw new ResourceNotFoundException("ShippingDetails not found with id "+shippingDetailsModel.getShippingId());	
		}
		else {
			ShippingDetails shippingDetails = convert(shippingDetailsModel);
			LOGGER.info("ShippingDetails deleted with id "+shippingDetailsModel.getShippingId());
			shippingDetailsRepository.delete(shippingDetails);
		}		
	}
}
