package com.vendas.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.apirest.models.Estoque;
import com.vendas.apirest.repository.EstoqueRepository;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class EstoqueResource {
	
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@GetMapping("/entradas")
	public List<Estoque> listaEntradas(){
		return estoqueRepository.findAll();
	}
	
	@GetMapping("/vendas_mes")
	public List vendasMes() {
		return estoqueRepository.listaVenda();
	}
	
	@PostMapping("/entrada")
	public Estoque registraEntrada(@RequestBody Estoque estoque) {
		estoque.setValorTotal(estoque.getValorUnitario() * estoque.getQtdeEntrada());
		return estoqueRepository.save(estoque);
	}
	
	@DeleteMapping("/entrada")
	public void deletaEstoque(@RequestBody Estoque estoque) {
		estoqueRepository.delete(estoque);
	}

}
