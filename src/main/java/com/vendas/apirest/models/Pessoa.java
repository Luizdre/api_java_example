package com.vendas.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cad_pessoa")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pessoa_id;
	
	private String pessoa_nome;
	
	private long pessoa_endereco;
	
	private String pessoa_cpf;
	
	private String pessoa_rg;
	
	private String pessoa_tipo;
	
	private String pessoa_telefone;
	
	private String pessoa_nasc;
	
	@Column(name="pessoa_usuario")
	private String pessoaUsuario;
	
	private String pessoa_senha;
	
	private String pessoa_ativo;

	public long getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	public String getPessoa_nome() {
		return pessoa_nome;
	}

	public void setPessoa_nome(String pessoa_nome) {
		this.pessoa_nome = pessoa_nome;
	}

	public long getPessoa_endereco() {
		return pessoa_endereco;
	}

	public void setPessoa_endereco(long pessoa_endereco) {
		this.pessoa_endereco = pessoa_endereco;
	}

	public String getPessoa_cpf() {
		return pessoa_cpf;
	}

	public void setPessoa_cpf(String pessoa_cpf) {
		this.pessoa_cpf = pessoa_cpf;
	}

	public String getPessoa_rg() {
		return pessoa_rg;
	}

	public void setPessoa_rg(String pessoa_rg) {
		this.pessoa_rg = pessoa_rg;
	}

	public String getPessoa_tipo() {
		return pessoa_tipo;
	}

	public void setPessoa_tipo(String pessoa_tipo) {
		this.pessoa_tipo = pessoa_tipo;
	}

	public String getPessoa_telefone() {
		return pessoa_telefone;
	}

	public void setPessoa_telefone(String pessoa_telefone) {
		this.pessoa_telefone = pessoa_telefone;
	}

	public String getPessoa_nasc() {
		return pessoa_nasc;
	}

	public void setPessoa_nasc(String pessoa_nasc) {
		this.pessoa_nasc = pessoa_nasc;
	}

	public String getPessoa_usuario() {
		return pessoaUsuario;
	}

	public void setPessoa_usuario(String pessoa_usuario) {
		this.pessoaUsuario = pessoa_usuario;
	}

	public String getPessoa_senha() {
		return pessoa_senha;
	}

	public void setPessoa_senha(String pessoa_senha) {
		this.pessoa_senha = pessoa_senha;
	}

	public String getPessoa_ativo() {
		return pessoa_ativo;
	}

	public void setPessoa_ativo(String pessoa_ativo) {
		this.pessoa_ativo = pessoa_ativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}