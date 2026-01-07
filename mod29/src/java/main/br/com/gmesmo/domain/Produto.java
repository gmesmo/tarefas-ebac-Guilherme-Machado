package br.com.gmesmo.domain;

public class Produto {
	private Long id;
	private String nome;
	private Double custo;
	private Double venda;
	
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
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	public Double getVenda() {
		return venda;
	}
	public void setVenda(Double venda) {
		this.venda = venda;
	}
	
	
	
}
