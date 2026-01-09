package br.com.gmesmo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import br.com.gmesmo.dao.ICarroDao;
import br.com.gmesmo.dao.CarroDao;
import br.com.gmesmo.domain.Carro;
import br.com.gmesmo.dao.IMarcaDao;
import br.com.gmesmo.dao.MarcaDao;
import br.com.gmesmo.domain.Marca;
import br.com.gmesmo.dao.IAcessoriosDao;
import br.com.gmesmo.dao.AcessoriosDao;
import br.com.gmesmo.domain.Acessorios;

public class CarroTest {

  private ICarroDao carroDao;
  private IMarcaDao marcaDao;
  private IAcessoriosDao acessoriosDao;

  public CarroTest() {
    carroDao = new CarroDao();
    marcaDao = new MarcaDao();
    acessoriosDao = new AcessoriosDao();
  }

  @Test
  public void cadastrar() {
    Carro carro = new Carro();

    carro.setCodigo("123");
    carro.setNome("Carro 1");
    carro.setPreco(new BigDecimal(50));
    carro.setAno(2022);

    Marca marca = new Marca();
    marca.setNome("Marca 1");
    marca = marcaDao.cadastrar(marca);
    carro.setMarca(marca);

    Acessorios acessorios = new Acessorios();
    acessorios.setNome("Acessorios 1");
    acessorios.setPreco(new BigDecimal(50));
    acessorios.setAno(2022);
    acessorios.setMarca(marca);
    acessorios = acessoriosDao.cadastrar(acessorios);

    List<Acessorios> acessoriosList = new ArrayList<>();
    acessoriosList.add(acessorios);
    carro.setAcessorios(acessoriosList);


    carro = carroDao.cadastrar(carro);

    assertNotNull(carro);
    assertNotNull(carro.getId());
  }

  @Test
  public void cadastrarMarca() {
    Marca marca = new Marca();
    marca.setNome("Marca 1");
    marca.setCarros(new ArrayList<>());

    marca = marcaDao.cadastrar(marca);

    assertNotNull(marca);
    assertNotNull(marca.getId());
  }

  @Test
  public void cadastrarAcessorios() {
    Acessorios acessorios = new Acessorios();
    acessorios.setNome("Acessorios 1");
    acessorios.setPreco(new BigDecimal(50));
    acessorios.setAno(2022);
    Marca marca = new Marca();
    marca.setNome("Marca 1");
    marca = marcaDao.cadastrar(marca);
    acessorios.setMarca(marca);
    acessorios.setCarros(new ArrayList<>());

    acessorios = acessoriosDao.cadastrar(acessorios);

    assertNotNull(acessorios);
    assertNotNull(acessorios.getId());
  }

  @Test
  public void listar() {
    List<Carro> carros = carroDao.listar();
    assertNotNull(carros);
    assertTrue(carros.isEmpty());
  }

  @Test
  public void excluir() {
    Carro carro = new Carro();
    carro.setCodigo("123");
    carro.setNome("Produto 1");
    carro.setPreco(new BigDecimal(50));
    carro.setAno(2022);
    
    Marca marca = new Marca();
    marca.setNome("Marca 1");
    marca = marcaDao.cadastrar(marca);
    carro.setMarca(marca);
    
    Acessorios acessorios = new Acessorios();
    acessorios.setNome("Acessorios 1");
    acessorios.setPreco(new BigDecimal(50));
    acessorios.setAno(2022);
    acessorios.setMarca(marca);
    acessorios = acessoriosDao.cadastrar(acessorios);
    
    List<Acessorios> acessoriosList = new ArrayList<>();
    acessoriosList.add(acessorios);
    carro.setAcessorios(acessoriosList);

    carro = carroDao.cadastrar(carro);

    assertNotNull(carro);
    assertNotNull(carro.getId());

    carroDao.excluir(carro.getId());

    List<Carro> carros = carroDao.listar();
    assertNotNull(carros);
    assertTrue(carros.isEmpty());
  }
}
