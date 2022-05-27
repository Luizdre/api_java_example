package com.vendas.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vendas.apirest.models.Carrinho;
import com.vendas.apirest.models.Pessoa;
import com.vendas.apirest.models.Produto;
import com.vendas.apirest.repository.CarrinhoRepository;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class CarrinhoResources {
	
	@Autowired
	CarrinhoRepository carrinhoRepository;
	
	@GetMapping("/carrinhos")
	public List<Carrinho> listaCarrinhos(){
		return carrinhoRepository.findAll();
	}
	
	@GetMapping("/carrinho/{id_pessoa}")
	public List<Carrinho> carrinhoUsuario(@PathVariable(value="id_pessoa") Long id){
		return carrinhoRepository.findByPessoa(id);
	}
	
	@GetMapping("/carrinho_completo/{pessoa}")
	public List carrinhoCompleto(@PathVariable(value = "pessoa") int pessoa) {
		return carrinhoRepository.listaCarrinhoInformacoes(pessoa);
	}
	
	@GetMapping("/carrinho_individual")
	public List carrinhoIndividual() {
		return carrinhoRepository.listaCarrinhoPessoa();
	}
	
	@PostMapping("/carrinho")
	public Carrinho adicionaProduto(@RequestBody Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}
	
	@GetMapping("/carrinho/venda/{id_pessoa}")
	public ResponseEntity<?> efetivaVenda(@PathVariable(value="id_pessoa") Long id) {
		String erro = null;
		String carrinho = null;
		try {
	    carrinho = carrinhoRepository.EfetivaVenda(id);
		} catch (Exception e) {
			return ResponseEntity.ok(e.getCause().getMessage());
		}
		return ResponseEntity.ok(carrinho);
	}
	
	@DeleteMapping("/carrinho")
	public void retiraProduto(@RequestBody Carrinho carrinho) {
		carrinhoRepository.delete(carrinho);
	}
	
	@PutMapping("/carrinho")
	public Carrinho atualizaCarrinho(@RequestBody Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}

}
