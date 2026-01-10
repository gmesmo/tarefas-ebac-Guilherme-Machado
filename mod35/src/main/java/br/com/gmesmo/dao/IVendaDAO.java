/**
 * 
 */
package br.com.gmesmo.dao;

import br.com.gmesmo.dao.generic.IGenericDAO;
import br.com.gmesmo.domain.Venda;
import br.com.gmesmo.exceptions.DAOException;
import br.com.gmesmo.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
