package br.com.gmesmo.dao;

import java.util.List;
import br.com.gmesmo.domain.Acessorios;

public interface IAcessoriosDao {

  public Acessorios cadastrar(Acessorios acessorios);
  public List<Acessorios> listar();
  public void excluir(Long id);
}
