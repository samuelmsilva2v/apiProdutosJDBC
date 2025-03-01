package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProdutoRequestDto;
import com.example.demo.entities.Produto;
import com.example.demo.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	private ProdutoService produtoService = new ProdutoService();

	@Operation(summary = "Serviço para cadastrar um produto.")
	@PostMapping("cadastrar")
	public String cadastrarProduto(@RequestBody @Valid ProdutoRequestDto request) {
		return produtoService.cadastrarProduto(request);
	}
	
	@Operation(summary = "Serviço para atualizar um produto.")
	@PutMapping("atualizar/{id}")
	public String atualizarProduto(@RequestBody @Valid ProdutoRequestDto request, @PathVariable UUID id) {
		return produtoService.atualizarProduto(request, id);
	}
	
	@Operation(summary = "Serviço para excluir um produto.")
	@DeleteMapping("excluir/{id}")
	public String excluirProduto(@PathVariable UUID id) {
		return produtoService.excluirProduto(id);
	}
	
	@Operation(summary = "Serviço para consultar todos os produtos.")
	@GetMapping("consultar")
	public List<Produto> consultarProdutos() {
		return produtoService.consultarProdutos();
	}
	
	@Operation(summary = "Serviço para consultar produtos por nome.")
	@GetMapping("consultar/{nome}")
	public List<Produto> consultarProdutosPorNome(@PathVariable String nome) {
		return produtoService.consultarProdutosPorNome(nome);
	}
	
	@Operation(summary = "Serviço para consultar um produto por id.")
	@GetMapping("consultar/id/{id}")
	public Produto consultarProdutoPorId(@PathVariable UUID id) {
		return produtoService.consultarProdutoPorId(id);
	}
}
