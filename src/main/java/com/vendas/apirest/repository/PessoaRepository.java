package com.vendas.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.apirest.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Pessoa findById(long pessoa_id);

	@Query(value = "SELECT * FROM CAD_PESSOA WHERE PESSOA_USUARIO = :usuario AND PESSOA_SENHA = :senha", nativeQuery = true)
	Pessoa findByPessoaUsuario(@Param("usuario") String usuario, @Param("senha") String senha);
	
	@Query(value = "SELECT * FROM CAD_PESSOA WHERE PESSOA_USUARIO = :usuario", nativeQuery = true)
	List<Pessoa> findPessoas(@Param("usuario") String pessoa_usuario);
	
	@Query(value = "SELECT * FROM CAD_PESSOA WHERE PESSOA_TIPO = 'Cliente' ORDER BY PESSOA_NOME", nativeQuery = true)
	List<Pessoa> listaCliente();
	
	@Query(value = "SELECT * FROM CAD_PESSOA WHERE PESSOA_TIPO = 'Fornecedor' ORDER BY PESSOA_NOME", nativeQuery = true)
	List<Pessoa> listaFornecedor();
	
	@Query(value = "SELECT * FROM VW_PESSOA WHERE pessoa_id = :id", nativeQuery = true)
	List<?> listaPessoa(@Param("id") int id);
	
	@Query(value = "SELECT * FROM CAD_PESSOA ORDER BY PESSOA_NOME", nativeQuery = true)
	List<Pessoa> ListaPessoaOrdenada();

}