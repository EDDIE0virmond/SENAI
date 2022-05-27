package br.com.senaibrasilia.projetofinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Product;

public class ProductDAO {
	private EntityManager util;

	public ProductDAO(EntityManager util) {
		super();
	this.util = util;	
	}
	public void iniciar() 
	{
		this.util.getTransaction().begin();
	}
	public void cadastrar (Product product) 
	{
		this.util.persist(product);
	}
	public void atualizar(Product product) 
	{
		this.util.merge(product);
	}
	public void remove(Product product) 
	{
		product = this.util.merge(product);
		this.util.remove(product);
	}
	public Product bucar(long id) 
	{
		return this.util.find(Product.class, id);
	}
	public List<Product> retorneTodosOsProdutos()
	{
		String jpalocate = "SELECT p FROM Product p";
		return this.util.createQuery(jpalocate, Product.class).getResultList();
	}
	public List<Product> buscarPorNome(String name )
	{
		String jpalocate = "SELECT p FROM Product p WHERE p.name = :name";
		return this.util.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class).setParameter("name", name).getResultList();
	}
	public void encerrar() 
	{
		this.util.close();
	}
	

}
