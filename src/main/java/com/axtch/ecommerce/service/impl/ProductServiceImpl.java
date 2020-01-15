package com.axtch.ecommerce.service.impl;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.axtch.ecommerce.model.Product;
import com.axtch.ecommerce.repository.ProductRepository;
import com.axtch.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	/**
	 * Constructor of Product
	 * 
	 * @param productRepository the repository of Product
	 * 
	 */
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent())
			return product.get();
		else {
			throw new NoSuchElementException("element does not exist");
		}
	}

	@Override
	public Product create(MultipartFile prodImage, String name, double price, String description, String provider)
			throws Exception {
		Product product = new Product();
		try {
			product.setName(name);
			product.setPrice(price);
			product.setDescription(description);
			product.setProvider(provider);
			product.setProductimage(prodImage.getBytes());
			productRepository.save(product);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productRepository.save(product);

	}

	@Override
	public Product update(Long id, Product product) {
		product.setId(id);
		return productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Page<Product> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> simpleSearch(String term, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
