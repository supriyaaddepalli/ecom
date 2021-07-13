package com.abc.ecom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.ContactUs;
import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.ContactUsModel;
import com.abc.ecom.repository.ContactUsRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	private ContactUsRepository contactUsRepository;
	
	private ContactUs convert(ContactUsModel contactUsModel) {
		ContactUs contactUs = new ContactUs();
		contactUs.setContactId(contactUsModel.getContactId());
		contactUs.setName(contactUsModel.getName());
		contactUs.setEmail(contactUsModel.getEmail());
		contactUs.setPhoneNumber(contactUsModel.getPhoneNumber());
		contactUs.setMessage(contactUsModel.getMessage());
		return contactUs;
	}

//			private ContactUsModel convert(Optional<ContactUs> optionalContactUs) {
//			ContactUsModel contactUsModel = new ContactUsModel();
//			contactUsModel.setContactId(contactUsModel.getContactId());
//			contactUsModel.setName(contactUsModel.getName());
//			contactUsModel.setEmail(contactUsModel.getEmail());
//			contactUsModel.setPhoneNumber(contactUsModel.getPhoneNumber());
//			contactUsModel.setMessage(contactUsModel.getMessage());
//			return contactUsModel;
//
//}

	@Override
	public void save(ContactUsModel contactUsModel)  throws ResourceNotFoundException {
		
		Optional<ContactUs> optionalContactUs = contactUsRepository.findById(contactUsModel.getContactId());
		if(optionalContactUs.isPresent()) {
			throw new ResourceAlreadyExistException("Contact details already found with id "+contactUsModel.getContactId());
		}
		else {
			ContactUs contactUs = convert(contactUsModel);
			contactUsRepository.save(contactUs);	
		}
		
	
	}

	@Override
	public void update(ContactUsModel contactUsModel)  throws ResourceNotFoundException {
		
		Optional<ContactUs> optionalContactUs = contactUsRepository.findById(contactUsModel.getContactId());
		if(optionalContactUs.isEmpty()) {
			throw new ResourceAlreadyExistException("Contact details already found with id "+contactUsModel.getContactId());
		}
		else {
			ContactUs contactUs = convert(contactUsModel);
			contactUsRepository.save(contactUs);	
		}
	
		
	}

	@Override
	public void delete(ContactUsModel contactUsModel)   throws ResourceNotFoundException{
		Optional<ContactUs> optionalContactUs = contactUsRepository.findById(contactUsModel.getContactId());
		if(optionalContactUs.isPresent()) {
			throw new ResourceAlreadyExistException("Contact details not found with id "+contactUsModel.getContactId());
		}
		else {
			ContactUs contactUs = convert(contactUsModel);
			contactUsRepository.delete(contactUs);	
		}
	
	}
		
	}
