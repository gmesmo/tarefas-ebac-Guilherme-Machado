/**
 * 
 */
package br.com.gmesmo.services;

import br.com.gmesmo.dao.IProdutoDAO;
import br.com.gmesmo.domain.Produto;
import br.com.gmesmo.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
