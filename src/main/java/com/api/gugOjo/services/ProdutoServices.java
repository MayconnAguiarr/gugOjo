package com.api.gugOjo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gugOjo.dtos.ProdutoDto;
import com.api.gugOjo.repository.ProdutoRepository;

@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository repository;
	
	public String adicionar(ProdutoDto produtoDto) {
		return repository.save(produtoDto);
	}
	
	public String atualizar(ProdutoDto produtoDto) {
		return repository.update(produtoDto);
	}
	
	public String remover(long id) {
		return repository.delete(id);
	}
}
