package com.axtch.ecommerce.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axtch.ecommerce.model.Product;
import com.axtch.ecommerce.service.ProductService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	
	/**
	 * Constructor of ProductController
	 * 
	 * @param productService the service of product
	 */
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(value ="/all")
	public List<Product> getProducts(){
		List <Product> productList = productService.findAll();
		return productList;
	}
	
	@GetMapping(value ="/{id}")
	public Product getProductById(@PathVariable(value ="id") Long id ) {
		return productService.findById(id);
	}
	
	@PostMapping//(consumes = {"multipart/form-data"})
	public Product createProduct(
			@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("price") double price,
			@RequestParam("description") String description,
			@RequestParam("provider") String provider
			) throws IOException, Exception {
		return productService.create(file, name, price, description, provider);
	}
	
	@DeleteMapping(value ="/{id}")
	public void deleteProduct(@PathVariable(value ="id")Long id) {
		 productService.delete(id);
	}
	
	
	

}
