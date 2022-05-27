package com.vendas.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.apirest.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	Endereco findById(long endereco_id);

}
