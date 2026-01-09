package br.com.gmesmo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gmesmo.domain.Produto;

public class ProdutoDao implements IProdutoDao {

	@Override
	public Produto cadastrar(Produto produto) {
		
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();


		return produto;
	}

	@Override
	public List<Produto> listar() {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Produto> produtos = entityManager.createQuery("from Produto", Produto.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return produtos;
	}

	@Override
	public void excluir(Long id) {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Produto produto = entityManager.find(Produto.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
