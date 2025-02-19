package com.example.demo.repositories;

import java.util.UUID;

import com.example.demo.entities.Produto;
import com.example.demo.factories.ConnectionFactory;

public class ProdutoRepository {

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public void register(Produto produto, UUID categoriaId) {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("INSERT INTO produto(id, nome, preco, quantidade, categoria_id) VALUES(?, ?, ?, ?, ?)");
			statement.setObject(1, produto.getId());
			statement.setString(2, produto.getNome());
			statement.setDouble(3, produto.getPreco());
			statement.setInt(4, produto.getQuantidade());
			statement.setObject(5, categoriaId);
			
			statement.execute();
			
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
