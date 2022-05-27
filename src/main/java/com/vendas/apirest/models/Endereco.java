package com.vendas.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cad_endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long endereco_id;
	
	private String endereco_rua;
	
	private String endereco_cidade;
	
	private String endereco_bairro;
	
	private String endereco_complemento;
	
	private String endereco_cep;
	
	private long endereco_numero;

	public long getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(long endereco_id) {
		this.endereco_id = endereco_id;
	}

	public String getEndereco_rua() {
		return endereco_rua;
	}

	public void setEndereco_rua(String endereco_rua) {
		this.endereco_rua = endereco_rua;
	}

	public String getEndereco_cidade() {
		return endereco_cidade;
	}

	public void setEndereco_cidade(String endereco_cidade) {
		this.endereco_cidade = endereco_cidade;
	}

	public String getEndereco_bairro() {
		return endereco_bairro;
	}

	public void setEndereco_bairro(String endereco_bairro) {
		this.endereco_bairro = endereco_bairro;
	}

	public String getEndereco_complemento() {
		return endereco_complemento;
	}

	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}

	public String getEndereco_cep() {
		return endereco_cep;
	}

	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}

	public long getEndereco_numero() {
		return endereco_numero;
	}

	public void setEndereco_numero(long endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
