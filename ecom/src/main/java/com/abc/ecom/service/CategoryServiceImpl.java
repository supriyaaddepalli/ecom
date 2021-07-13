package com.abc.ecom.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Categories;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ResourceAlreadyExistException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.model.CategoriesModel;
import com.abc.ecom.model.ProductModel;
import com.abc.ecom.repository.CategoryRepository;
/**
 * 
 * @author supriya
 * date - 06-Jul-2021
 */

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	/**
	 * This method is to convert Optional Category to CategotyModel
	 * @param optionalCategories
	 * @return CategoriesModel
	 */
	private CategoriesModel convert(Optional<Categories> optionalCategories) {
		CategoriesModel categoriesModel = new CategoriesModel();
		categoriesModel.setCategoryId(optionalCategories.get().getCategoryId());
		categoriesModel.setCategoryType(optionalCategories.get().getCategoryType());
		List<Product> products = optionalCategories.get().getProducts();
		List<ProductModel> productModels = new ArrayList<>();
		Iterator<Product> i = products.iterator();
		while(i.hasNext()) {
			Product p =i.next();
			ProductModel productModel = new ProductModel();
			productModel.setProductId(p.getProductId());
			productModel.setProductName(p.getProductName());
			productModel.setProductPrice(p.getProductPrice());
			productModels.add(productModel);			
	}
		categoriesModel.setProductModels(productModels);
		return categoriesModel;
	}
	
	/**
	 * This method is to convert CategoryModel to Category
	 * @param categoriesModel
	 * @return
	 */
	private Categories convert(CategoriesModel categoriesModel) {
		Categories categories = new Categories();
		categories.setCategoryId(categoriesModel.getCategoryId());
		categories.setCategoryType(categoriesModel.getCategoryType());
		List<ProductModel> productModels = categoriesModel.getProductModels();
		List<Product> products = new ArrayList<>();
		Iterator<ProductModel> i = productModels.iterator();
		while(i.hasNext()) {
			ProductModel productModel = i.next();
			Product product = new Product();
			product.setProductId(productModel.getProductId());
			product.setProductName(productModel.getProductName());
			product.setProductPrice(productModel.getProductPrice());
			products.add(product);
			
			}
		categories.setProducts(products);
		return categories;
	}
	
	/**
	 * THis method is inherited from CategoryService
	 *  {@inheritDoc}
	 */
	@Override
	public void saveCategory(CategoriesModel categoriesModel) throws ResourceAlreadyExistException {
		
		LOGGER.info("CategoryServiceImpl :: saveCategory(CategoriesModel categoriesModel) method is called.");
		Optional<Categories> optionalCategories = categoryRepository.findById(categoriesModel.getCategoryId());
		
		if(optionalCategories.isPresent()) {
			LOGGER.error("ResourceAlreadyExistException with id"+categoriesModel.getCategoryId());
			throw new ResourceAlreadyExistException("Category already exist with id"+categoriesModel.getCategoryId());
			}
		
		else {
			Categories categories = convert(categoriesModel);
			LOGGER.info("Category saved with id "+categoriesModel.getCategoryId());
			categoryRepository.save(categories);
		}
	}
	
	/**
	 * His method is inherited from CategoryService
	 *  {@inheritDoc}
	 */
	@Override
	public void deleteCategory(CategoriesModel categoriesModel) throws ResourceNotFoundException {
		
		LOGGER.info("CategoryServiceImpl :: deleteCategory(CategoriesModel categoriesModel) method is called.");
		Optional<Categories> optionalCategories = categoryRepository.findById(categoriesModel.getCategoryId());
		
		if(optionalCategories.isEmpty()) {
			LOGGER.error("ResourceNotFoundException with id",categoriesModel.getCategoryId());
			throw new ResourceNotFoundException("category not found with id "+categoriesModel.getCategoryId());
			}
		else {
			Categories categories = convert(categoriesModel);
			LOGGER.info("Category deleted with id ",categoriesModel.getCategoryId());
			categoryRepository.delete(categories);
		}			
	}
	
	/**
	 * His method is inherited from CategoryService
	 *  {@inheritDoc}
	 */
	@Override
	public CategoriesModel fetchById(int categoryId) throws ResourceNotFoundException {
		LOGGER.info("CategoryServiceImpl :: fetchById(int categoryId) method is called.");
		Optional<Categories> optionalCategories = categoryRepository.findById(categoryId);
		if(optionalCategories.isEmpty()) {
			LOGGER.error("ResourceNotFoundException with id"+categoryId);
			throw new ResourceNotFoundException("category not found with id "+categoryId);
		}
		else {
			CategoriesModel categoriesModel=convert(optionalCategories);
			return categoriesModel;	
			}	
	}
	
	/**
	 * 	His method is inherited from CategoryService	
	 *  {@inheritDoc}
	 */
	@Override
	public CategoriesModel fetchByType(String categoryName) throws ResourceNotFoundException{
		LOGGER.info("CategoryServiceImpl :: fetchByType(String categoryName) method is called.");
		Optional<Categories> optionalCategories = categoryRepository.findBycategoryType(categoryName);
		if(optionalCategories.isEmpty()) {
			LOGGER.error("ResourceNotFoundException with CategoryType"+categoryName);
			throw new ResourceNotFoundException("category not found with id "+categoryName);
		}
		else {
			CategoriesModel categoriesModel=convert(optionalCategories);
			return categoriesModel;
		}		
	}

	/**
	 * His method is inherited from CategoryService
	 *  {@inheritDoc}
	 */
	@Override
	public void updateProductListInCategory(CategoriesModel categoriesModel) throws ResourceNotFoundException{
		LOGGER.info("CategoryServiceImpl :: updateProductListInCategory(CategoriesModel categoriesModel) method is called.");
		Optional<Categories> optionalCategories = categoryRepository.findById(categoriesModel.getCategoryId());
		
		if(optionalCategories.isEmpty()) {
			LOGGER.error("ResourceNotFoundException with id",categoriesModel.getCategoryId());
			throw new ResourceNotFoundException("category not found with id "+categoriesModel.getCategoryId());
			}		
		else {
			Categories categories = convert(categoriesModel);
			LOGGER.info("Category updated with id ",categoriesModel.getCategoryId());
			categoryRepository.save(categories);
		}		
	}
}
