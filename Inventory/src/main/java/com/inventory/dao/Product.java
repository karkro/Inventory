package com.inventory.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	private long id;
	private String name;
	private Category category;
	private String description;
	private float price;
	
	public Product() {
		
	}
	
	public Product(String name, Category category, String description, float price) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	@Id
	@Column(name = "product_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@Column(name = "category_id")
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
}
