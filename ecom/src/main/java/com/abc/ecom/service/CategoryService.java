package com.abc.ecom.service;

import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.CategoriesModel;

/**
 * 
 * @author supriya
 * date - 05-Jul-2021
 */
public interface CategoryService {
	/**
	 * This method is to save Products in the dataBase
	 * @param categoriesModel- 
	 * @throws ResourceAlreadyExistException
	 */
	public void saveCategory(CategoriesModel categoriesModel) throws ResourceAlreadyExistException;
	/**
	 * This method is to delete products in dataBase
	 * @param categoriesModel
	 * @throws ResourceNotFoundException
	 */
	public void deleteCategory(CategoriesModel categoriesModel) throws ResourceNotFoundException;
	/**
	 * This method is to find Category With reference to ID of category
	 * @param categoryId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public CategoriesModel fetchById(int categoryId) throws ResourceNotFoundException;
	/**
	 * This method is to find Category with reference to Type of Category
	 * @param categoryName
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public CategoriesModel fetchByType(String categoryName) throws ResourceNotFoundException;

	/**
	 * This method is to update product list in category
	 * @param categoriesModel
	 */
	public void updateProductListInCategory(CategoriesModel categoriesModel);
}
