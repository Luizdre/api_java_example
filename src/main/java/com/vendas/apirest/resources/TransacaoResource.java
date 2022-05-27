package com.vendas.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.apirest.models.Transacao;
import com.vendas.apirest.repository.TransacaoRepository;

@RestController
@RequestMapping(value = "api")
@CrossOrigin(origins = "*")
public class TransacaoResource {
	
	@Autowired
	TransacaoRepository transacaoRepository;
	
	@GetMapping("/venda_mes/{mesInicial}&{mesFinal}&{ano}")
	public ResponseEntity relacaoVendas(@PathVariable(value = "mesInicial") Long mesInicial,
							  @PathVariable(value = "mesFinal") Long mesFinal, 
							  @PathVariable(value = "ano") Long ano) {
		List venda = null;
		try {
			venda = transacaoRepository.relacaoVendas(mesInicial, mesFinal, ano);
		} catch (Exception e) {
			ResponseEntity.ok(e.getCause().getMessage());
		}
		return ResponseEntity.ok(venda);
	}
	
	@GetMapping("/lucros_mes/{mesInicial}&{mesFinal}&{ano}")
	public ResponseEntity relacaoLucro(@PathVariable(value = "mesInicial") Long mesInicial,
							  @PathVariable(value = "mesFinal") Long mesFinal, 
							  @PathVariable(value = "ano") Long ano) {
		List lucro = null;
		try {
			lucro = transacaoRepository.relacaoLucro(mesInicial, mesFinal, ano);
		} catch (Exception e) {
			ResponseEntity.ok(e.getCause().getMessage());
		}
		return ResponseEntity.ok(lucro);
	}
	
	@GetMapping("/transacoes")
	public List<Transacao> listaTransacoes() {
		return transacaoRepository.findAllByOrderByIdAsc();
	}
	
	@GetMapping("/transacao/descricoes")
	public List<Transacao> Transacoes() {
		return (List<Transacao>) transacaoRepository.descricoes();
	}
	
	@GetMapping("/transacao/{id}")
	public Transacao TransacaoUnica(@PathVariable(value = "id") long id) {
		return transacaoRepository.getById(id);
	}
	
	@GetMapping("/vendas")
	public List<?> vendas(){
		return transacaoRepository.vendas();
	}
	
	@GetMapping("/venda/deleta/{id}")
	public void deletaVenda(@PathVariable(value="id") long id) {
		transacaoRepository.deletaVenda(id);
	}
	
	@PostMapping("/transacao")
	public Transacao salvaTransacao(@RequestBody Transacao transacao) {
		return transacaoRepository.save(transacao);
	}

}
