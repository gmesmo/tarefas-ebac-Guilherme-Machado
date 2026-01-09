package br.com.gmesmo.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ACESSORIOS")
public class Acessorios {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acessorios")
  @SequenceGenerator(name = "seq_acessorios", sequenceName = "sq_acessorios", initialValue = 1, allocationSize = 1)
  private Long id;

  @Column(name = "NOME", length = 50, nullable = false)
  private String nome;

  @Column(name = "PRECO", nullable = false)
  private BigDecimal preco;

  @Column(name = "ANO", nullable = false)
  private Integer ano;

  @ManyToOne
  @JoinColumn(name = "ID_MARCA",
    foreignKey = @ForeignKey(name = "FK_ACESSORIOS_MARCA"),
    referencedColumnName = "ID", nullable = false
  )
  private Marca marca;

  @ManyToMany
  @JoinTable(name = "TB_ACESSORIOS_CARRO",
    joinColumns = @JoinColumn(name = "ID_ACESSORIOS", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "ID_CARRO", referencedColumnName = "ID")
  )
  private List<Carro> carros;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public Marca getMarca() {
    return marca;
  }

  public void setMarca(Marca marca) {
    this.marca = marca;
  }

  public List<Carro> getCarros() {
    return carros;
  }

  public void setCarros(List<Carro> carros) {
    this.carros = carros;
  }
}
