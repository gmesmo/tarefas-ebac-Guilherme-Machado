/**
 * 
 */
package br.com.gmesmo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gmesmo.dao.jdbc.ConnectionFactory;
import br.com.gmesmo.domain.Produto;

/**
 * 
 */
public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_PRODUTOS (ID, NOME, PRECO_CUSTO, PRECO_VENDA) VALUES (NEXTVAL('SQ_PRODUTOS'), ?, ?, ?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getNome());
			stm.setDouble(2, produto.getCusto());
			stm.setDouble(3, produto.getVenda());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Produto consultar(String nome) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTOS WHERE NOME = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			
			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setCusto(rs.getDouble("preco_custo"));
				produto.setVenda(rs.getDouble("preco_venda"));
			}
			return produto;
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_PRODUTOS WHERE ID = ?";
			stm = connection.prepareStatement(sql);
			stm.setLong(1, produto.getId());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<Produto> all() throws Exception {
	    Connection connection = null;
	    PreparedStatement stm = null;
	    ResultSet rs = null;
	    List<Produto> produtos = new ArrayList<>();

	    try {
	        connection = ConnectionFactory.getConnection();
	        String sql = "SELECT * FROM TB_PRODUTOS";
	        stm = connection.prepareStatement(sql);
	        rs = stm.executeQuery();

	        while (rs.next()) {
	            Produto produto = new Produto();
	            produto.setId(rs.getLong("id"));
	            produto.setNome(rs.getString("nome"));
	            produto.setCusto(rs.getDouble("preco_custo"));
	            produto.setVenda(rs.getDouble("preco_venda"));
	            produtos.add(produto);
	        }

	        return produtos;
	    } finally {
	        if (rs != null && !rs.isClosed()) {
	            rs.close();
	        }
	        if (stm != null && !stm.isClosed()) {
	            stm.close();
	        }
	        if (connection != null && !connection.isClosed()) {
	            connection.close();
	        }
	    }
	}


	@Override
	public boolean update(Produto produtoUp) throws Exception {
	    Connection connection = null;
	    PreparedStatement stm = null;

	    try {
	        connection = ConnectionFactory.getConnection();
	        String sql = "UPDATE TB_PRODUTOS SET NOME = ? WHERE ID = ?";
	        stm = connection.prepareStatement(sql);
	        stm.setString(1, produtoUp.getNome());
	        stm.setLong(2, produtoUp.getId());

	        int rowsAffected = stm.executeUpdate();
	        return rowsAffected > 0;
	    } finally {
	        if (stm != null && !stm.isClosed()) stm.close();
	        if (connection != null && !connection.isClosed()) connection.close();
	    }
	}

}
