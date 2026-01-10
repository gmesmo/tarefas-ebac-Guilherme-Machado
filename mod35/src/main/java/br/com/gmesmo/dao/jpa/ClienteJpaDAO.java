/**
 * 
 */
package br.com.gmesmo.dao.jpa;

import br.com.gmesmo.dao.generic.jpa.GenericJpaDAO;
import br.com.gmesmo.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
