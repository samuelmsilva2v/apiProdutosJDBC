package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.entities.Categoria;
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
	
	public void update(Produto produto, UUID categoriaId) {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("UPDATE produto SET nome = ?, preco = ?, quantidade = ?, categoria_id = ? WHERE id = ?");
			statement.setString(1, produto.getNome());
			statement.setDouble(2, produto.getPreco());
			statement.setInt(3, produto.getQuantidade());	
			statement.setObject(4, categoriaId);
			statement.setObject(5, produto.getId());
			statement.execute();
			
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(UUID id) {

		try {

			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
			statement.setObject(1, id);
			statement.execute();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> findAll() {
		
		try {
		
			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement("SELECT * FROM produto");
			var result = statement.executeQuery();
			
			var produtos = new ArrayList<Produto>();

			while (result.next()) {
				
				var produto = new Produto();
				produto.setId(UUID.fromString(result.getString("id")));
				produto.setNome(result.getString("nome"));
				produto.setPreco(result.getDouble("preco"));
				produto.setQuantidade(result.getInt("quantidade"));
				
				produtos.add(produto);
			}
			
			connection.close();
			
			return produtos;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Produto> findByName(String nome) {
		
		try {
			
			var connection = connectionFactory.getConnection();
            
            var query = """
            		SELECT
            			p.id as idproduto, p.nome as nomeproduto, 
            		        		p.preco, p.quantidade,
            			c.id as idcategoria, c.nome as nomecategoria
            		FROM produto p
            		INNER JOIN categoria c
            		ON c.id = p.categoria_id
            		WHERE p.nome ILIKE ?
            		ORDER BY p.nome;
         """;
            
            var statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");
            
            var result = statement.executeQuery();
            
            var produtos = new ArrayList<Produto>();
            
            while (result.next()) {
            	
                var produto = new Produto();
                produto.setCategoria(new Categoria());
                
                produto.setId(UUID.fromString(result.getString("idproduto")));
                produto.setNome(result.getString("nomeproduto"));
                produto.setPreco(result.getDouble("preco"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.getCategoria().setId(UUID.fromString(result.getString("idcategoria")));
                produto.getCategoria().setNome(result.getString("nomecategoria"));
                
                produtos.add(produto);
            }
            
            connection.close();
            return produtos;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Produto findById(UUID id) {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var query = """
					SELECT
						p.id as idproduto, p.nome as nomeproduto, p.preco, p.quantidade,
						c.id as idcategoria, c.nome as nomecategoria
					FROM produto p
					INNER JOIN categoria c
					ON c.id = p.categoria_id
					WHERE p.id = ?
					""";
			
			var statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			
			var result = statement.executeQuery();

			Produto produto = null;
			
			if(result.next()) {
				
				produto = new Produto();
				produto.setCategoria(new Categoria());
				
				produto.setId(UUID.fromString(result.getString("idproduto")));
				produto.setNome(result.getString("nomeproduto"));
				produto.setPreco(result.getDouble("preco"));
				produto.setQuantidade(result.getInt("quantidade"));
				produto.getCategoria().setId(UUID.fromString(result.getString("idcategoria")));
				produto.getCategoria().setNome(result.getString("nomecategoria"));
			}
			
			connection.close();
			return produto;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
