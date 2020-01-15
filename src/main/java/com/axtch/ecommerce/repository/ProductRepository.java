package com.axtch.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.axtch.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
