package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.DashboardResponseDto;
import com.example.demo.repositories.CategoriaRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
	
	private CategoriaRepository categoriaRepository = new CategoriaRepository();

	@Operation(summary = "Serviço para consultar o total de produtos por categoria.")
	@GetMapping("produtos-por-categoria")
	public List<DashboardResponseDto> produtosCategoria() {
		return categoriaRepository.groupByQtdProdutos();
	}
}
