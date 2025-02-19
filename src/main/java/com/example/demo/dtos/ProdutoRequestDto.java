package com.example.demo.dtos;

import java.util.UUID;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProdutoRequestDto {

	@Size(min = 6, max = 100, message = "O nome do produto deve ter entre 6 e 100 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do produto.")
	private String nome;
	
	@DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que R$ 0,00.")
	@Digits(integer = 10, fraction = 2, message = "O preço do produto deve ter no máximo 10 dígitos inteiros e 2 dígitos decimais.")
	@NotNull(message = "Por favor, informe o preço do produto.")
	private Double preco;
	
	@Min(value = 1, message = "A quantidade do produto deve ser maior que 0.")
	@NotNull(message = "Por favor, informe a quantidade do produto.")
	private Integer quantidade;
	
	@NotNull(message = "Por favor, informe a categoria do produto.")
	private UUID categoriaId;
}
