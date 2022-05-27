package br.com.senaibrasilia.projetofinal.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
	public static javax.persistence.EntityManager factory ()
	{
		return entityManagerFactory.createEntityManager();
	}  
}
