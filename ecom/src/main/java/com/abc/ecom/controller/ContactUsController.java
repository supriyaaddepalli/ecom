package com.abc.ecom.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.model.ContactUsModel;
import com.abc.ecom.service.ContactUsService;
/**
 * 
 * @author supriya
 * date - 10-Jul-2021
 */
@RestController
@RequestMapping("/contactDetails")
@Validated
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsController.class);
	/**
	 * This method is to add Query
	 * @param contactUsModel
	 * @return ResponseEntity
	 */
	@PostMapping("/saveContactUs")
	public ResponseEntity<?> addContactUs(@RequestBody @Valid ContactUsModel contactUsModel){
		LOGGER.info("Requested /api/contactus/saveContactUs endpoint");
		contactUsService.save(contactUsModel);
		LOGGER.info("Contact details added sucessfully");
		return new ResponseEntity<>("Contact details Added ",HttpStatus.CREATED);
	}
	/**
	 * This method is to delete query
	 * @param contactUsModel
	 * @return ResponseEntity
	 */
	@PostMapping("/deleteContactUs")
	public ResponseEntity<?> removeContactUs(@RequestBody @Valid ContactUsModel contactUsModel){
		LOGGER.info("Requested /api/contactus/removeContactUs endpoint");
		contactUsService.delete(contactUsModel);
		LOGGER.info("Contact details deleted sucessfully");
		return new ResponseEntity<>("Contact details deleted ",HttpStatus.CREATED);
	}
	
	/**
	 * This method is to update Query
	 * @param contactUsModel
	 * @return ResponseEntity
	 */
	@PutMapping("/updateContactUs")
	public ResponseEntity<?> updateContactUs(@RequestBody @Valid ContactUsModel contactUsModel){
		LOGGER.info("Requested /api/contactUs/updateContactUs endpoint.");
		contactUsService.update(contactUsModel);
		return new ResponseEntity<>("updated sucessfully",HttpStatus.OK);
	}
}
