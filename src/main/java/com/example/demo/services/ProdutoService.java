package com.example.demo.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProdutoRequestDto;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository = new ProdutoRepository();

	public String cadastrarProduto(ProdutoRequestDto request) {
		
		var produto = new Produto();
		
		produto.setId(UUID.randomUUID());
		produto.setNome(request.getNome());
		produto.setPreco(request.getPreco());
		produto.setQuantidade(request.getQuantidade());
		
		produtoRepository.register(produto, request.getCategoriaId());
		
		return "Produto cadastrado com sucesso!";
	}

	public void atualizarProduto() {
		// TODO
	}

	public void excluirProduto() {
		// TODO
	}

	public void consultarProdutos() {
		// TODO
	}
}
