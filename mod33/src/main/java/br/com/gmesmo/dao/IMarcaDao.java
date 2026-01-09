package br.com.gmesmo.dao;

import java.util.List;
import br.com.gmesmo.domain.Marca;

public interface IMarcaDao {

  public Marca cadastrar(Marca marca);
  public List<Marca> listar();
  public void excluir(Long id);
}
