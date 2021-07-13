/**
 * 
 */
package com.abc.ecom.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Admin;
import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.AdminModel;
import com.abc.ecom.repository.AdminRepository;
/**
 * 
 * @author supriya
 * date - 11-Jul-2021
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminRepository adminRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	/**
	 * implements saveAdmin from adminservice interface
	 * {@inheritDoc}
	 */
	@Override
	public void saveAdmin(AdminModel admin) throws ResourceAlreadyExistException {
		
		LOGGER.info("adminRepository::findById(int id)method called");
		
		Optional<Admin> adminentity1 =adminRepository.findByAdminName(admin.getAdminName());
		if(adminentity1.isPresent()) {
			throw new ResourceAlreadyExistException("Admin is already exist with this Name"+admin.getAdminName());
		}
		else {
			
			Admin adminentity= new Admin();
			adminentity.setEmail(admin.getEmail());
			adminentity.setAdminName(admin.getAdminName());
			adminentity.setPassword(admin.getPassword());
			adminRepository.save(adminentity);
			LOGGER.info("admin details saved in repository");
		
		}
		LOGGER.info("Exiting from adminServiceImpl::saveAdmin(Admin admin)method");
		
	}
	/**
	 *  implements deleteAdmin from adminservice interface
	 * {@inheritDoc}
	 */
	
	@Override
	public void deleteAdminbyId(int id) throws ResourceNotFoundException {		
		LOGGER.info("FindById method called from adminServiceImpl::deleteAdminbyId method");		
		Optional<Admin> adminEntity =adminRepository.findById(id);
		if(adminEntity.isPresent()) {
			adminRepository.deleteById(id);		
			LOGGER.info("DELETED the given Doctor Details");
		}
		else {	
			LOGGER.error("ResourceNotFoundException encountered with id ",id);	
		throw new ResourceNotFoundException ("can not find Admin with this Id "+id);
		}		
		LOGGER.info("Exiting from adminServiceImpl::deleteAdminbyId(int id)method");
	} 
	
	
}
