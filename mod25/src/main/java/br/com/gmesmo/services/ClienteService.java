package br.com.gmesmo.services;

import br.com.gmesmo.domain.Cliente;
import br.com.gmesmo.services.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService {
	
	public ClienteService() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}
	
}
