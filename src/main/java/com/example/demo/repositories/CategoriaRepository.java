package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.entities.Categoria;
import com.example.demo.factories.ConnectionFactory;

public class CategoriaRepository {

	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public List<Categoria> findAll() {

		try {

			var connection = connectionFactory.getConnection();
			var statement = connection.createStatement();
			var result = statement.executeQuery("SELECT * FROM categoria");

			var lista = new ArrayList<Categoria>();

			while (result.next()) {

				var categoria = new Categoria();
				categoria.setId(UUID.fromString(result.getString("id")));
				categoria.setNome(result.getString("nome"));

				lista.add(categoria);
			}

			connection.close();
			return lista;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
