package br.com.senaibrasilia.projetofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GenerationType;



@javax.persistence.Entity
@javax.persistence.Table(name="Carrinho")
public class Cart {
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@javax.persistence.ManyToOne(targetEntity = Product.class)
	private List<Product> product = new ArrayList<>();
}
