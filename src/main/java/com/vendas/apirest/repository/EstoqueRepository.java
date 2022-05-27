package com.vendas.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vendas.apirest.models.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	@Query(value="select * from vw_vendasmes", nativeQuery=true)
	List listaVenda();

}
