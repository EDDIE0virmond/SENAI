package br.com.senaibrasilia.projetofinal.model;

import javax.persistence.GenerationType;

@javax.persistence.Entity
@javax.persistence.Table(name = "Client")
public class Client {
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private String address;
	private String phone;
	public Client(String name, String cpf, String address, String phone) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.phone = phone;
	}
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
