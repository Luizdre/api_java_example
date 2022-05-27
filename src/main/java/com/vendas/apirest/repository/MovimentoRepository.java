package com.vendas.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.apirest.models.Movimentacao;

public interface MovimentoRepository extends JpaRepository<Movimentacao, Long>{

}
