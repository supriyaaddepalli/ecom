package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.ContactUs;
import com.abc.ecom.model.ContactUsModel;
import com.abc.ecom.repository.ContactUsRepository;

/**
 * @author avanika Anjali
 *
 */
@SpringBootTest
public class ContactUsServiceTest {
	
	@Mock
	private ContactUsRepository contactUsRepository;

	@InjectMocks
	private ContactUsServiceImpl contactUsServiceImpl;
	/**
	 *This method is to test Update ContactUs
	 */
	@Test
	public void testUpdateContactUs() {
		//ContactUsModel contactUsModel = new ContactUsModel();
		ContactUs contactUs = new ContactUs();
		contactUs.setContactId(1);
		contactUs.setName("Anjali");
		contactUs.setEmail("abc@gmail.com");
		contactUs.setPhoneNumber((long) 788367111);
		contactUs.setMessage("thank you");
         when(contactUsRepository.save(contactUs)).thenReturn(contactUs);
		 assertEquals(1, contactUs.getContactId());
	}
	/**
	 *This method is to test saveContactUs
	 */
	@Test
	public void testsaveContactUs() {
		ContactUs contactUsModel = new ContactUs();
		contactUsModel.setName("Anjali");
		contactUsModel.setContactId(1);
		contactUsModel.setEmail("abc@gmail.com");
		contactUsModel.setPhoneNumber((long) 788367111);
		contactUsModel.setMessage("thank you");
		
		//contactUsServiceImpl.save(contactUsModel);
		 when(contactUsRepository.save(contactUsModel)).thenReturn(contactUsModel);
		 assertEquals(1, contactUsModel.getContactId());
	}
	/**
	 *This method is to test Delete Shipping Details
	 */
	@Test
	public void testDeleteContactUs() {
		ContactUsModel contactUsModel = new ContactUsModel();
		contactUsModel.setContactId(1);
		contactUsModel.setName("Anjali");
		contactUsModel.setEmail("abc@gmail.com");
		contactUsModel.setPhoneNumber((long) 788367111);
		contactUsModel.setMessage("thank you");	
		contactUsServiceImpl.delete(contactUsModel);

}
}

