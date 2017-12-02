package com.api.gugOjo.repository;

import org.springframework.stereotype.Repository;

import com.api.gugOjo.dtos.ProdutoDto;

@Repository
public class ProdutoRepository {
	
	public String save(ProdutoDto produtoDto) {
		return "Sucess!";
	}
	
	public String update(ProdutoDto produtoDto) {
		return "Updated";
	}
	
	public String delete(long id) {
		return "deleted";
	}

}

