package com.vendas.apirest.resources;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.apirest.models.Pessoa;
import com.vendas.apirest.repository.PessoaRepository;

import ch.qos.logback.core.status.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
@Api(value="API Rest Vendas")
@CrossOrigin(origins="*")
public class PessoaResource {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna lista de pessoas")
	public List<Pessoa> listaPessoa(){
		return pessoaRepository.ListaPessoaOrdenada();
	}
	
	@GetMapping("/pessoaCompleto/{id}")
	public List listaPessoaCompleta(@PathVariable(value="id") int id) {
		return pessoaRepository.listaPessoa(id);
	}
	
	@GetMapping("/pessoa/{pessoa_id}")
	@ApiOperation(value="Retorna uma pessoa")
	public Pessoa listaPessoaUnica(@PathVariable(value="pessoa_id") long id) {
		return pessoaRepository.findById(id);
	}
	
	@GetMapping("/clientes")
	public List<Pessoa> listaClientes() {
		return pessoaRepository.listaCliente();
	}
	
	@GetMapping("/fornecedores")
	public List<Pessoa> listaFornecedores() {
		return pessoaRepository.listaFornecedor();
	}
	
	@GetMapping("/usuario/{pessoa_usuario}&{pessoa_senha}")
	@ApiOperation(value="Retorna uma pessoa")
	public ResponseEntity<Optional<Pessoa>> listaUsuario(@PathVariable(value="pessoa_usuario") String usuario, @PathVariable(value="pessoa_senha") String senha) {
		Optional<Pessoa> ususario = Optional.ofNullable(pessoaRepository.findByPessoaUsuario(usuario, senha));
		return !ususario.isEmpty() ? //ResponseEntity.status(HttpStatus.OK).build() 
			ResponseEntity.ok(ususario)	: ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

	@PostMapping("/pessoa")
	@ApiOperation(value="Salva um registro de pessoa")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa")
	@ApiOperation(value="Deleta um registro de pessoa")
	public void deletaPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	@PutMapping("/pessoa/{id}")
	@ApiOperation(value="Atualiza um registro de pessoa")
	public Pessoa atualizaPessoa(@PathVariable(value="id") long id, @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}
