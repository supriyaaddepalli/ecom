package com.abc.ecom.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.exception.ObjectResponse;
import com.abc.ecom.model.CategoriesModel;
import com.abc.ecom.service.CategoryService;
/**
 * 
 * @author supriya
 * date - 10-Jul-2021
 */
@RestController
@RequestMapping("/Category")
@Validated
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ObjectResponse objectResponse;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	/**
	 * This method is to save Category
	 * @param categoriesModel
	 * @return ResponseEntity
	 */
	@PostMapping("/saveCategory")
	public ResponseEntity<?> addcategory(@RequestBody @Valid CategoriesModel categoriesModel){
		LOGGER.info("Requested /Category/saveCategory endpoint.");
		categoryService.saveCategory(categoriesModel);
		LOGGER.info("Sucessfully returned newly added categories");
		objectResponse.setMessage("category Added");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.CREATED);
	}
	/**
	 * This method is to delete Category
	 * @param categoriesModel
	 * @return ResponseEntity
	 */
	@PostMapping("/deleteCategory")
	public ResponseEntity<?> removeCategory(@RequestBody CategoriesModel categoriesModel){	
		LOGGER.info("Requested /category/deleteCategory endpoint.");
		categoryService.deleteCategory(categoriesModel);
		LOGGER.info("Sucessfully returned after removing Category");
		objectResponse.setMessage("category deleted");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.CREATED);
	}
	/**
	 * This method is find CategoryType by Id
	 * @param categoryId
	 * @return ResponseEntity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> findcategoryById(@Min(100) @PathVariable("id") int categoryId){
		LOGGER.info("Getting the Category with id ",categoryId);
		CategoriesModel categoriesModel = categoryService.fetchById(categoryId);
		return new ResponseEntity<>(categoriesModel,HttpStatus.OK);
	}
	
	/**
	 * This method is to get category by Name of category
	 * @param categoryType
	 * @return ResponseEntity
	 */
	@GetMapping("/byType/{name}")
	public ResponseEntity<?> findcategoryByType( @PathVariable("name") String categoryType){
		LOGGER.info("Getting the Category with Type ",categoryType);
		CategoriesModel categoriesModel = categoryService.fetchByType(categoryType);
		return new ResponseEntity<>(categoriesModel,HttpStatus.OK);
	}
	
	/**
	 * This method is to update Category
	 * @param categoriesModel
	 * @return ResponseEntity
	 */
	@PutMapping("/updateCategory")
	public ResponseEntity<?> updateCategory(@RequestBody @Valid CategoriesModel categoriesModel){
		LOGGER.info("Requested /category/updateCategory endpoint.");
		categoryService.updateProductListInCategory(categoriesModel);
		objectResponse.setMessage("category updated");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
	}
}
