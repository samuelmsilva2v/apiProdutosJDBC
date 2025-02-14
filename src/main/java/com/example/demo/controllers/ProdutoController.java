package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@PostMapping("cadastrar")
	public void cadastrarProduto() {
		// TODO
	}
	
	@PutMapping("atualizar")
	public void atualizarProduto() {
		// TODO
	}
	
	@DeleteMapping("excluir")
	public void excluirProduto() {
		// TODO
	}
	
	@PostMapping("consultar")
	public void consultarProdutos() {
		// TODO
	}
}
