package br.com.senaibrasilia.projetofinal.model;


@javax.persistence.Entity
@javax.persistence.Table(name = "Categoria")
public class Catgory {
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private int id;
	private String name;
	public Catgory() {
		super();
	}
	public Catgory( String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
