package com.vendas.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.apirest.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
	@Query(value = "SELECT * FROM fc_relacao_venda(:mesInicial, :mesFinal, :ano)", nativeQuery = true)
	List<?> relacaoVendas(@Param("mesInicial") Long mesInicial, @Param("mesFinal") Long mesFinal, @Param("ano") Long ano);
	
	@Query(value = "SELECT * FROM fc_relacao_lucros(:mesInicial, :mesFinal, :ano)", nativeQuery = true)
	List<?> relacaoLucro(@Param("mesInicial") Long mesInicial, @Param("mesFinal") Long mesFinal, @Param("ano") Long ano);
	
	@Query(value="SELECT distinct descricao_transacao, tipo_transacao from transacao where descricao_transacao not like '%Compra de Produtos -%'", nativeQuery = true)
	List<?> descricoes();
	
	@Query(value="SELECT * FROM vw_vendas", nativeQuery = true)
	List<?> vendas();
	
	@Query(value="DELETE FROM VENDAS WHERE ID = :idVenda", nativeQuery=true)
	void deletaVenda(@Param("idVenda") Long idVenda);
	
	List<Transacao> findAllByOrderByIdAsc();
	
	

}
