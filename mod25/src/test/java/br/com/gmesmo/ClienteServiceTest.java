package br.com.gmesmo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.gmesmo.dao.ClienteDaoMock;
import br.com.gmesmo.dao.IClienteDAO;
import br.com.gmesmo.domain.Cliente;
import br.com.gmesmo.exceptions.TipoChaveNaoEncontradaException;
import br.com.gmesmo.service.ClienteServiceMock;
import br.com.gmesmo.services.ClienteService;
import br.com.gmesmo.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		clienteService = new ClienteServiceMock();
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12345678910L);
		cliente.setNome("Guilherme");
		cliente.setCidade("Porto Alegre");
		cliente.setEnd("End");
		cliente.setEstado("RS");
		cliente.setNumero(10);
		cliente.setTel(51999999999L);
	}
	
	@Test
	public void PesquisarCliente() {
		Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Guilherme Machado");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Guilherme Machado", cliente.getNome());
	}
}
