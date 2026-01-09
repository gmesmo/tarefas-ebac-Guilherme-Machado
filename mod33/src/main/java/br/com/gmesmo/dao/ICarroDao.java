package br.com.gmesmo.dao;

import java.util.List;
import br.com.gmesmo.domain.Carro;

public interface ICarroDao {

  public Carro cadastrar(Carro carro);
  public List<Carro> listar();
  public void excluir(Long id);
}
