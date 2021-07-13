package com.abc.ecom.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.exception.ObjectResponse;
import com.abc.ecom.model.ProductModel;
import com.abc.ecom.service.ProductService;

@RestController
@RequestMapping("/Product")
@Validated
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ObjectResponse objectResponse;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	/**
	 * This method is to add product 
	 * @param productModel
	 * @return ResponseEntity
	 */
	@PostMapping("/save")
	public ResponseEntity<?> addProduct(@RequestBody @Valid ProductModel productModel){
		LOGGER.info("Requested /product/save endpoint");
		productService.saveProduct(productModel);
		objectResponse.setMessage("product Added");
		objectResponse.setStatus(HttpStatus.OK.value());
		LOGGER.info("Product added sucessfully");
		return new ResponseEntity<>(objectResponse,HttpStatus.CREATED);
	}
	/**
	 * This Method is to remove Products
	 * @param productModel
	 * @return ResponseEntity
	 */
	@PostMapping("/deleteById")
	public ResponseEntity<?> removeProduct(@RequestBody ProductModel productModel ){
		LOGGER.info("Requested /product/delete endpoint");
		productService.deleteProduct(productModel.getProductId());
		LOGGER.info("Product removed sucessfully");
		objectResponse.setMessage("product deleted");
		objectResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
	}
	
	/**
	 * This Method is to Update product
	 * @param productModel
	 * @return ResponseEntity
	 */
	@PutMapping("/updateById")
	public ResponseEntity<?> updateProduct(@RequestBody ProductModel productModel ){
		LOGGER.info("Requested /api/product/updateProduct endpoint");
		productService.updateProduct(productModel);
		objectResponse.setMessage("product updated");
		objectResponse.setStatus(HttpStatus.OK.value());
		LOGGER.info("Product updated sucessfully");
		return new ResponseEntity<>(objectResponse,HttpStatus.OK);
	}
	/**
	 * This method is to get list of products
	 * @return ResponseEntity
	 */
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProducts(){
		LOGGER.info("Requested /product/findAllProducts endpoint");
		List<ProductModel> productModel =productService.findAllProducts();
		LOGGER.info("product details list obtained");
		return new ResponseEntity<>(productModel,HttpStatus.OK);
	}
	
}
