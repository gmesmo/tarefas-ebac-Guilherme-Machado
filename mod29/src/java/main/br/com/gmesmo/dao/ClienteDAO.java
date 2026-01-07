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
import br.com.gmesmo.domain.Cliente;

/**
 * 
 */
public class ClienteDAO implements IClienteDAO {

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES (NEXTVAL('SQ_CLIENTE'), ?, ?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
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
	public Cliente consultar(String codigo) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_CLIENTE WHERE CODIGO = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
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
	public Integer excluir(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_CLIENTE WHERE CODIGO = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
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
	public List<Cliente> all() throws Exception {
	    Connection connection = null;
	    PreparedStatement stm = null;
	    ResultSet rs = null;
	    List<Cliente> clientes = new ArrayList<>();

	    try {
	        connection = ConnectionFactory.getConnection();
	        String sql = "SELECT * FROM TB_CLIENTE";
	        stm = connection.prepareStatement(sql);
	        rs = stm.executeQuery();

	        while (rs.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setId(rs.getLong("id"));
	            cliente.setCodigo(rs.getString("codigo"));
	            cliente.setNome(rs.getString("nome"));
	            clientes.add(cliente);
	        }

	        return clientes;
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
	public boolean update(Cliente clienteUp) throws Exception {
	    Connection connection = null;
	    PreparedStatement stm = null;

	    try {
	        connection = ConnectionFactory.getConnection();
	        String sql = "UPDATE TB_CLIENTE SET NOME = ? WHERE CODIGO = ?";
	        stm = connection.prepareStatement(sql);
	        stm.setString(1, clienteUp.getNome());
	        stm.setString(2, clienteUp.getCodigo());

	        int rowsAffected = stm.executeUpdate();
	        return rowsAffected > 0;
	    } finally {
	        if (stm != null && !stm.isClosed()) stm.close();
	        if (connection != null && !connection.isClosed()) connection.close();
	    }
	}

}
