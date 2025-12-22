/**
 * 
 */
package br.com.gmesmo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.gmesmo.dao.ClienteDaoMock;
import br.com.gmesmo.dao.IClienteDAO;
import br.com.gmesmo.domain.Cliente;
import br.com.gmesmo.exceptions.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;

	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDao = new ClienteDaoMock();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12345678910L);
		cliente.setNome("Guilherme");
		cliente.setCidade("Porto Alegre");
		cliente.setEnd("End");
		cliente.setEstado("RS");
		cliente.setNumero(10);
		cliente.setTel(51999999999L);
		clienteDao.cadastrar(cliente);
	}
	
	@Test
	public void PesquisarCliente() {
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteDao.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Guilherme Machado");
		clienteDao.alterar(cliente);
		
		Assert.assertEquals("Guilherme Machado", cliente.getNome());
	}
}
