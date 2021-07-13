/**
 * 
 */
package com.abc.ecom.service;

import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.AdminModel;

public interface AdminService {
	
	    /**
	     * 
	     * @param admin
	     * @throws ResourceAlreadyExistException
	     */
	    public void saveAdmin(AdminModel adminmodel) throws ResourceAlreadyExistException;
		/**
		 * 
		 * @param name
		 * @throws ResourceNotFoundException
		 */
		public void deleteAdminbyId(int id) throws ResourceNotFoundException ;
	
}
