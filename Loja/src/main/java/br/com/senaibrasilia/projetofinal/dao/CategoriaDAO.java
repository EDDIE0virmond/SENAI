package br.com.senaibrasilia.projetofinal.dao;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Catgory;

public class CategoriaDAO {
	private EntityManager util;

	public CategoriaDAO(EntityManager util) {
		super();
	this.util = util;	
	}
	public void cadastrar (Catgory category) 
	{
		this.util.persist(category);
	}
	public void atualizar (Catgory category) 
	{
		this.util.merge(category);
	}
	public void remover (Catgory category) 
	{
		category = util.merge(category);
		this.util.remove(category);
	}
}
