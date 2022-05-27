package com.vendas.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.apirest.models.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
	List<Carrinho> findByPessoa(Long id_pessoa);
	
	@Query(value = "SELECT fc_registra_venda(:pessoa)", nativeQuery = true)
		String EfetivaVenda(@Param("pessoa") Long id_pessoa);
	
	@Query(value= "SELECT * FROM VW_CARRINHO WHERE PESSOA_ID = :pessoa", nativeQuery=true)
		List<?> listaCarrinhoInformacoes(@Param("pessoa") int pessoa);
	
	@Query(value= "SELECT DISTINCT pessoa_nome, pessoa_cpf, SUM(qtde_produto) as qtde, pessoa_id from vw_carrinho GROUP BY PESSOA_ID, PESSOA_NOME, PESSOA_CPF ORDER BY pessoa_nome ASC;", nativeQuery=true)
	List<?> listaCarrinhoPessoa();

}
