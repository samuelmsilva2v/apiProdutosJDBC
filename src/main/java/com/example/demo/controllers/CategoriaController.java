package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoriaRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	private CategoriaRepository categoriaRepository = new CategoriaRepository();
	
	@Operation(summary = "Serviço para consultar todas as categorias.")
	@GetMapping("consultar")
	public List<Categoria> consultar() {
		return categoriaRepository.findAll();
	}
}
