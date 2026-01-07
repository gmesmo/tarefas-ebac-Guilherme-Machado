/**
 * 
 */
package br.com.gmesmo.dao;

import java.util.List;

import br.com.gmesmo.domain.Produto;

/**
 * 
 */
public interface IProdutoDAO {
	
	public Integer cadastrar(Produto produto) throws Exception;

	public Produto consultar(String codigo) throws Exception;

	public Integer excluir(Produto produtoBD) throws Exception;

	public List<Produto> all() throws Exception;

	public boolean update(Produto produto) throws Exception;

}
