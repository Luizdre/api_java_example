package com.vendas.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.apirest.models.Movimentacao;
import com.vendas.apirest.repository.MovimentoRepository;

@RestController
@RequestMapping(value = "api")
@CrossOrigin(origins = "*")
public class MovimentoResource {
	
	@Autowired
	MovimentoRepository movimentoRepository;
	
	@GetMapping("/movimentos")
	public List<Movimentacao> listaMovimentos(){
		return movimentoRepository.findAll();
	}
	
	@PostMapping("/movimento")
	public Movimentacao registraMovimento(@RequestBody Movimentacao movimento) {
		return movimentoRepository.save(movimento);
	}

}
