package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProdutoRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Operation(summary = "Serviço para cadastrar um produto.")
	@PostMapping("cadastrar")
	public void cadastrarProduto(@RequestBody @Valid ProdutoRequestDto request) {
		// TODO
	}
	
	@Operation(summary = "Serviço para atualizar um produto.")
	@PutMapping("atualizar")
	public void atualizarProduto() {
		// TODO
	}
	
	@Operation(summary = "Serviço para excluir um produto.")
	@DeleteMapping("excluir")
	public void excluirProduto() {
		// TODO
	}
	
	@Operation(summary = "Serviço para consultar todos os produtos.")
	@PostMapping("consultar")
	public void consultarProdutos() {
		// TODO
	}
}
