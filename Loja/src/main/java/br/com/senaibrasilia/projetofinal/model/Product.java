package br.com.senaibrasilia.projetofinal.model;

import java.math.BigDecimal;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity
@javax.persistence.Table(name = "Product")
public class Product {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private BigDecimal price;
	@javax.persistence.ManyToOne(targetEntity = Catgory.class)
	private Catgory catgory;
	public Product(String name, String description, BigDecimal price, Catgory catgory) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.catgory = catgory;
	}
	public Product() {
		super();
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return this.price;
	}
	public void setPrice(BigDecimal preco) {
		this.price = preco;
	}
	public Catgory getCatgory() {
		return catgory;
	}
	
}
