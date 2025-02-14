package com.example.demo.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Categoria {

	private UUID id;
	private String nome;
	// TODO private List<Produto> produtos;
}
