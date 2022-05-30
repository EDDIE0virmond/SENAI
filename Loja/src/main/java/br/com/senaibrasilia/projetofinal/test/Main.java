package br.com.senaibrasilia.projetofinal.test;
import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDAO;
import br.com.senaibrasilia.projetofinal.dao.ProductDAO;
import br.com.senaibrasilia.projetofinal.model.Catgory;
import br.com.senaibrasilia.projetofinal.model.Product;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static EntityManager manager = JPAUtil.factory();
	private static Catgory catgory = new Catgory();
	private static Product product = new Product();
	private static ProductDAO productDAO = new ProductDAO(manager);
	private static CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
	public static void main(String[] args) {
		//cadastroProduct("Eletronico", 800, "Mause", "Botao com um cabo conectado no PC");
		manager.getTransaction().begin();
		catgory = new Catgory("Doces");
		product = new Product("Bolo De Chocolate ","Gostosissimo De Mais Para um Carilho", new BigDecimal(69.90), catgory);
		//productDAO.cadastrar(product);
		//categoriaDAO.cadastrar(catgory);
		manager.getTransaction().commit();
		for (int i = 0; i < productDAO.retorneTodosOsProdutos().size() ; i++) 
		{
			System.out.println(productDAO.retorneTodosOsProdutos().get(i).getName() + "||" + productDAO.retorneTodosOsProdutos().get(i).getDescription()  + "||"+ productDAO.retorneTodosOsProdutos().get(i).getCatgory().getName() + "||" + productDAO.retorneTodosOsProdutos().get(i).getPrice() + "||" + productDAO.retorneTodosOsProdutos().get(i).getId() );	
		}
		System.out.println("Deseja Saber algum produto, pelo nome ");
		String nameToSearch = scanner.next();
		for(int i = 0; i < productDAO.buscarPorNome(nameToSearch).size(); i++) 
		{
			System.out.println(productDAO.buscarPorNome(nameToSearch).get(i).getId() + "||" + productDAO.buscarPorNome(nameToSearch).get(i).getName() + "||" + productDAO.buscarPorNome(nameToSearch).get(i).getCatgory().getName()+ "||" + productDAO.buscarPorNome(nameToSearch).get(i).getPrice() + "||" + productDAO.buscarPorNome(nameToSearch).get(i).getDescription());			
		}
		System.out.println("Adicione um Produto\nSua Categoria");
		String categoria = scanner.next();
		System.out.println("Valor");
		double new_value_product = scanner.nextDouble();
		System.out.println("O produto");
		String new_name_product = scanner.next();
		System.out.println("SUA Descricao");
		String new_descricao_product = scanner.next();
		cadastroProduct(categoria, new_value_product, new_name_product, new_descricao_product);
		System.out.println("Deseja alterar, digite o id, se quiser sair digite -1 \n"
				+ "Quantidade de ids eles sao lineares " + productDAO.retorneTodosOsProdutos().size() + "\n");
		int dd = scanner.nextInt();
		if (dd != -1) 
		{
			System.out.println("Alterar a categora");
			String category = scanner.next();
			atualizarProdCategory(category, dd);
			System.out.println("Alterar o nome");
			String nome = scanner.next();
			atualizarProdName(nome , dd);
			System.out.println("Alterar a descricao");
			String description = scanner.next();
			atualizarProdDescription(description, dd);
			System.out.println("Alterar o valor");
			double val = scanner.nextDouble();
			atualizarProdValue(val, dd);
			
		}
		manager.close();

	}
	private static void cadastroProduct(String categoria, double val, String produto, String descricao) 
	{
		catgory = new Catgory(categoria);
		product = new Product(produto, descricao , new BigDecimal(val), catgory);
		manager.getTransaction().begin();
		categoriaDAO.cadastrar(catgory);
		productDAO.cadastrar(product);
		manager.getTransaction().commit();
		
	}
	private static void atualizarProdName( String name, int id) 
	{
		Product product = productDAO.bucar(id);
		product.setName(name);
		manager.getTransaction().begin();
		productDAO.atualizar(product);
		manager.getTransaction().commit();
	}
	private static void atualizarProdDescription( String name, int id) 
	{
		Product product = productDAO.bucar(id);
		product.setDescription(name);
		manager.getTransaction().begin();
		productDAO.atualizar(product);
		manager.getTransaction().commit();
		
	}
	private static void atualizarProdCategory( String name, int id) 
	{
		Product product = productDAO.bucar(id);
		product.getCatgory().setName(name);
		manager.getTransaction().begin();
		productDAO.atualizar(product);
		manager.getTransaction().commit();
	}
	private static void atualizarProdValue( double value, int id) 
	{
		Product product = productDAO.bucar(id);
		product.setPrice(new BigDecimal(value));
		manager.getTransaction().begin();
		productDAO.atualizar(product);
		manager.getTransaction().commit();
	}
}
