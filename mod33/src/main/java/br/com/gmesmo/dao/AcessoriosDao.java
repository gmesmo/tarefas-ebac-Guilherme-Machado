package br.com.gmesmo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gmesmo.domain.Acessorios;

public class AcessoriosDao implements IAcessoriosDao {

	@Override
	public Acessorios cadastrar(Acessorios acessorios) {
		
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(acessorios);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();


		return acessorios;
	}

	@Override
	public List<Acessorios> listar() {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Acessorios> acessorios = entityManager.createQuery("from Acessorios", Acessorios.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return acessorios;
	}

	@Override
	public void excluir(Long id) {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Acessorios acessorios = entityManager.find(Acessorios.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(acessorios);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
