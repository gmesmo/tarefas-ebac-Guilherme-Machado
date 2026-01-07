/**
 * 
 */
package br.com.gmesmo;

import org.junit.Assert;
import org.junit.Test;

import br.com.gmesmo.dao.ClienteDAO;
import br.com.gmesmo.dao.IClienteDAO;
import br.com.gmesmo.domain.Cliente;

/**
 * 
 */
public class ClienteTest {

	@Test
	public void cadastrarTest() throws Exception{
		 IClienteDAO dao = new ClienteDAO();
		 
		 Cliente cliente = new Cliente();
		 cliente.setCodigo("01");
		 cliente.setNome("Guilherme");
		 
		 Integer qtd = dao.cadastrar(cliente);
		 Assert.assertTrue(qtd == 1);
		 
		 cliente.setCodigo("02");
		 cliente.setNome("Judy");
		 qtd = dao.cadastrar(cliente);
		 Assert.assertTrue(qtd == 1);
		 
		 Cliente clienteBD = dao.consultar(cliente.getCodigo());
		 Assert.assertNotNull(clienteBD);
		 Assert.assertNotNull(clienteBD.getId());
		 Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		 Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
		 
		 Integer qtdBuscar = dao.all().size();
		 Assert.assertTrue(qtdBuscar == 2);
		 
		 cliente.setNome("JudyMesmo");
		 boolean clienteUpdate = dao.update(cliente);
		 Assert.assertTrue(clienteUpdate);
		 
		 Integer qtdDel = dao.excluir(clienteBD);
		 Assert.assertTrue(qtdDel == 1);
		 
		 qtdBuscar = dao.all().size();
		 Assert.assertTrue(qtdBuscar == 1);
	}
}
