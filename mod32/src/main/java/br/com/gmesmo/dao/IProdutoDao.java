package br.com.gmesmo.dao;

import java.util.List;
import br.com.gmesmo.domain.Produto;

public interface IProdutoDao {

  public Produto cadastrar(Produto produto);
  public List<Produto> listar();
  public void excluir(Long id);
}
