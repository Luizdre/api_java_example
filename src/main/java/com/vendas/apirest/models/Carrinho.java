package com.vendas.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrinho")
public class Carrinho implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long Id;
	
	@Column(name = "id_item")
	private long item;
	
	@Column(name = "id_pessoa")
	private long pessoa;
	
	@Column(name = "preco")
	private double preco;
	
	@Column(name = "qtde_produto")
	private long qtde;
	
	@Column(name = "status")
	private char status;
	
	@Column(name= "venda")
	private long venda;

	public long getVenda() {
		return venda;
	}

	public void setVenda(long venda) {
		this.venda = venda;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public long getQtde() {
		return qtde;
	}

	public void setQtde(long qtde) {
		this.qtde = qtde;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getItem() {
		return item;
	}

	public void setItem(long item) {
		this.item = item;
	}

	public long getPessoa() {
		return pessoa;
	}

	public void setPessoa(long pessoa) {
		this.pessoa = pessoa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
