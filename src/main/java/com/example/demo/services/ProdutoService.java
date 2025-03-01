package com.example.demo.services;

import java.util.List;
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

	public String atualizarProduto(ProdutoRequestDto request, UUID id) {
		
		var produto = new Produto();
		produto.setId(id);
		produto.setNome(request.getNome());
		produto.setPreco(request.getPreco());
		produto.setQuantidade(request.getQuantidade());

		produtoRepository.update(produto, request.getCategoriaId());
		
		return "Produto atualizado com sucesso!";
	}

	public String excluirProduto(UUID id) {
		
		produtoRepository.delete(id);
		return "Produto excluído com sucesso!";
	}

	public List<Produto> consultarProdutos() {

		return produtoRepository.findAll();
	}
	
	public List<Produto> consultarProdutosPorNome(String nome) {

		return produtoRepository.findByName(nome);
	}
	
	public Produto consultarProdutoPorId(UUID id) {
		
		return produtoRepository.findById(id);
	}
}
