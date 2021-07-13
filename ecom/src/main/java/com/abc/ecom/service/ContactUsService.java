/**
 * 
 */
package com.abc.ecom.service;

import com.abc.ecom.model.ContactUsModel;


/**
 * @author supriya
 * date - 07-Jul-2021
 */
public interface ContactUsService {
	
	public void save(ContactUsModel contactUsModel);

	public void update(ContactUsModel contactUsModel);
	
	public void delete(ContactUsModel contactUsModel);
	
	
}
