/**
 * 
 */
package com.abc.ecom.service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.abc.ecom.entity.Admin;
import com.abc.ecom.repository.AdminRepository;

/**
 * @author supriya
 * date - 12-Jul-2021
 */
public class AdminServiceTest {
	
	@Mock
	private AdminRepository adminRepository;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@Test
	public void testFindAdminById() {
		
		Admin admin = new Admin();
		admin.setAdminId(101);
		admin.setAdminName("ram");
		admin.setEmail("ram@gmail.com");
		
	}
	@Test
	public void testSaveAdmin() {
		Admin admin = new Admin();
			admin.setAdminId(101);
			admin.setAdminName("ram");
			admin.setEmail("ram@gmail.com");   
     }
	
}
