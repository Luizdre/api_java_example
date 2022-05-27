package com.vendas.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findById(long id);
	
	List<Produto> findByOrderByNomeAsc();
	
}