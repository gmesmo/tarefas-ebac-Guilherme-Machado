/**
 * 
 */
package br.com.gmesmo.dao;

import java.util.List;

import br.com.gmesmo.domain.Cliente;

/**
 * 
 */
public interface IClienteDAO {
	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

	public List<Cliente> all() throws Exception;

	public boolean update(Cliente cliente) throws Exception;

}
