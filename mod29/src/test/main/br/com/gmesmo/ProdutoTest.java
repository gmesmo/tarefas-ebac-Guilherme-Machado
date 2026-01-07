/**
 * 
 */
package br.com.gmesmo;

import org.junit.Assert;
import org.junit.Test;

import br.com.gmesmo.dao.ProdutoDAO;
import br.com.gmesmo.dao.IProdutoDAO;
import br.com.gmesmo.domain.Produto;

/**
 * 
 */
public class ProdutoTest {

	@Test
	public void cadastrarTest() throws Exception{
		 IProdutoDAO dao = new ProdutoDAO();
		 
		 Produto produto = new Produto();
		 produto.setNome("Refrigerante");
		 produto.setCusto(4.57);
		 produto.setVenda(9.98);
		 
		 Integer qtd = dao.cadastrar(produto);
		 Assert.assertTrue(qtd == 1);
		 
		 produto.setNome("Suco");
		 produto.setCusto(8.20);
		 produto.setVenda(11.50);
		 qtd = dao.cadastrar(produto);
		 Assert.assertTrue(qtd == 1);
		 
		 Produto produtoBD = dao.consultar(produto.getNome());
		 Assert.assertNotNull(produtoBD);
		 Assert.assertNotNull(produtoBD.getId());
		 Assert.assertEquals(produto.getNome(), produtoBD.getNome());
		 Assert.assertEquals(produto.getCusto(), produtoBD.getCusto());
		 Assert.assertEquals(produto.getVenda(), produtoBD.getVenda());
		 
		 Integer qtdBuscar = dao.all().size();
		 Assert.assertTrue(qtdBuscar == 2);
		 
		 produtoBD.setNome("Suco de Laranja");
		 boolean clienteUpdate = dao.update(produtoBD);
		 Assert.assertTrue(clienteUpdate);
		 
		 Integer qtdDel = dao.excluir(produtoBD);
		 Assert.assertTrue(qtdDel == 1);
		 
		 qtdBuscar = dao.all().size();
		 Assert.assertTrue(qtdBuscar == 1);
	}
}
