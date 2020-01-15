package com.axtch.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private Double price;

	@Column
	@NotNull
	private String description;

	@Column
	@NotNull
	private String provider;

	@Column
	@Lob
	private byte[] productimage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product() {
		super();
	}

	public Product(Long id, @NotNull String name, @NotNull Double price, @NotNull String description,
			@NotNull String provider, byte[] productimage) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.provider = provider;
		this.productimage = productimage;
	}

}
