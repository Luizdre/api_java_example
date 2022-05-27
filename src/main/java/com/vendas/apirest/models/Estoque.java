package com.vendas.apirest.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name="id_produto")
	@NotNull
	private long produto;
	
	@Column(name="fornecedor")
	@NotNull
	private String fornecedor;
	
	@Column(name="valor_unitario")
	@NotNull
	private double valorUnitario;
	
	@Column(name="tipo_entrada")
	@NotNull
	private char tipoEntrada;
	
	@Column(name="data_entrada")
	private Date dataEntrada;
	
	@Column(name="qtde_entrada")
	@NotNull
	private long qtdeEntrada;
	
	@Column(name="valor_total")
	private double valorTotal = (valorUnitario * qtdeEntrada);

	public long getId() {
		return id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProduto() {
		return produto;
	}

	public void setProduto(long produto) {
		this.produto = produto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public char getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(char tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public long getQtdeEntrada() {
		return qtdeEntrada;
	}

	public void setQtdeEntrada(long qtdeEntrada) {
		this.qtdeEntrada = qtdeEntrada;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
