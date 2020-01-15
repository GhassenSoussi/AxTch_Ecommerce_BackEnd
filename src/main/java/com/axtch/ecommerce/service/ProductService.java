package com.axtch.ecommerce.service;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.axtch.ecommerce.model.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	Page<Product> findAllByPage(Pageable pageable);
	
	Product findById(Long id);
	
	Page<Product> simpleSearch(String term, Pageable pageable);
	
	Product create(MultipartFile prodImage, String name, double price, String description, String provider) throws IOException, Exception;
	
	Product update(Long id, Product product);
	
	void delete(Long id);
	
}
