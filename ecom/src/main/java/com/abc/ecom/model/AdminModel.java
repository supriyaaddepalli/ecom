package com.abc.ecom.model;

import javax.validation.constraints.NotEmpty;
/**
 * 
 * @author supriya
 * date - 09-Jul-2021
 */
public class AdminModel  {
	
	    private int adminId;
		@NotEmpty(message = "Admin Name required")
		private String adminName;
		@NotEmpty(message = "Email is required")
		private String email;
		
		@NotEmpty(message = "password is requires")
		private String password;
		
		
		
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * getter methods for admin name 
		 * @return adminName
		 */
		public String getAdminName() {
			return adminName;
		}
		
		/**
		 * setter methods for adminName
		 * @param adminName
		 */
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		
		/**
		 * getter method for email
		 * @return email
		 */
		public String getEmail() {
			return email;
		}
		
		/**
		 * setter method for email
		 * @param email
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
		 * getter method for adminId
		 * @return adminId
		 */

		public int getAdminId() {
			return adminId;
		}
		
		/**
		 * setter method for adminId
		 * @param adminId
		 */

		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}

	}
