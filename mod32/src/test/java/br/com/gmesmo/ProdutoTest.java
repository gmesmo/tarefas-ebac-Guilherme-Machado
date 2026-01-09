package br.com.gmesmo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import java.util.List;
import br.com.gmesmo.dao.IProdutoDao;
import br.com.gmesmo.dao.ProdutoDao;
import br.com.gmesmo.domain.Produto;

public class ProdutoTest {

  private IProdutoDao produtoDao;

  public ProdutoTest() {
    produtoDao = new ProdutoDao();
  }

  @After
  public void finalizar() {
    List<Produto> produtos = produtoDao.listar();
    for (Produto produto : produtos) {
      produtoDao.excluir(produto.getId());
    }
  }

  @Test
  public void cadastrar() {
    Produto produto = new Produto();
    produto.setCodigo("123");
    produto.setNome("Produto 1");
    produto.setPreco(new BigDecimal(50));

    produto = produtoDao.cadastrar(produto);

    assertNotNull(produto);
    assertNotNull(produto.getId());
  }

  @Test
  public void listar() {
    List<Produto> produtos = produtoDao.listar();
    assertNotNull(produtos);
    assertTrue(produtos.isEmpty());
  }

  @Test
  public void excluir() {
    Produto produto = new Produto();
    produto.setCodigo("123");
    produto.setNome("Produto 1");
    produto.setPreco(new BigDecimal(50));

    produto = produtoDao.cadastrar(produto);

    assertNotNull(produto);
    assertNotNull(produto.getId());

    produtoDao.excluir(produto.getId());

    List<Produto> produtos = produtoDao.listar();
    assertNotNull(produtos);
    assertTrue(produtos.isEmpty());
  }
}
