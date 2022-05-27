package com.vendas.apirest.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.apirest.models.Endereco;
import com.vendas.apirest.repository.EnderecoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
@Api(value="API Rest Vendas")
@CrossOrigin(origins="*")
public class EnderecoResource {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@GetMapping("/enderecos")
	@ApiOperation(value="Retorna uma lista de endereços")
	public List<Endereco> listaEndereco(){
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/endereco/{endereco_id}")
	@ApiOperation(value="Retorna um endereco")
	public Endereco listaEnderecoUnico(@PathVariable(value="endereco_id") long id) {
		return enderecoRepository.findById(id);
	}
	
	@PostMapping("/endereco")
	@ApiOperation(value="Insere um registro de endereço")
	public Endereco salvaEndereco(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@DeleteMapping("/endereco")
	@ApiOperation(value="Deleta um registro de endereço")
	public void deleteEndereco(@RequestBody Endereco endereco) {
		enderecoRepository.delete(endereco);
	}
	
	@PutMapping("/endereco/{id}")
	@ApiOperation(value="Atualiza um registro de endereço")
	public Endereco atualizaEndereco(@PathVariable(value="id") long id, @RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
