
package com.abc.ecom.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.model.AdminModel;
import com.abc.ecom.service.AdminService;
/**
 * 
 * @author ramireddy
 * date - 10-Jul-2021
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	
	/**
	 * This method is to save Admin 
	 * @param adminmodel
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveAdmin(@Valid @RequestBody AdminModel adminmodel) {
		adminService.saveAdmin(adminmodel);
		LOGGER.info("adminserviceimp::saveAdmin(Admin admin) method calling");
		return new ResponseEntity<>(adminmodel.getAdminName() + " Your Profile is Saved Successfully", HttpStatus.CREATED);	
	}
	
	/**
	 * This method is to delete Admin by Id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@Valid @PathVariable("id") int id) {
		adminService.deleteAdminbyId(id);
		LOGGER.info("adminserviceimp::deleteAdmin(Admin admin) method calling");
		return new ResponseEntity<>("admin deleted succesfully", HttpStatus.FOUND);
	}
}
