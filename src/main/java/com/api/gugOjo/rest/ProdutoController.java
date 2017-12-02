package com.api.gugOjo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.gugOjo.dtos.ProdutoDto;
import com.api.gugOjo.services.ProdutoServices;

@RestController
@RequestMapping("/v1/gugOjo/produto")
public class ProdutoController {

	@Autowired
	private ProdutoServices produtoServices;

	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<?> listart() {
		System.out.println("list");
		return new ResponseEntity<String>("Banco de dados não configurado", HttpStatus.OK);
	}

	@RequestMapping(value="/cadastrar", method=RequestMethod.POST, consumes="application/json" )
	public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDto produtoDto) {
		String mensagem = produtoServices.adicionar(produtoDto);
		
		System.out.println("Cadastrar");
		System.out.println("Nome : " + produtoDto.getNome());
		System.out.println("Valor : " + produtoDto.getValor());
		return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
	}

	@RequestMapping(value = "atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @RequestBody ProdutoDto produtoDto) {
		String mensagem = produtoServices.atualizar(produtoDto);
		
		System.out.println("Atualizar");
		System.out.println("ID : " + id);
		System.out.println("Nome : " + produtoDto.getNome());
		System.out.println("Valor : " + produtoDto.getValor());
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	}

	@RequestMapping(value = "/remover/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		String mensagem = produtoServices.remover(id);

		System.out.println("Remover");
		System.out.println("ID : " + id);
		
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	}
}
