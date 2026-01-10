/**
 * 
 */
package br.com.gmesmo.dao.jpa;

import br.com.gmesmo.dao.generic.jpa.GenericJpaDAO;
import br.com.gmesmo.domain.jpa.ProdutoJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
