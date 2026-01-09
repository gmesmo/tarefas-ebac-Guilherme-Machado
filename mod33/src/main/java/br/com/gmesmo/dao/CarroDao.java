package br.com.gmesmo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gmesmo.domain.Carro;

public class CarroDao implements ICarroDao {

	@Override
	public Carro cadastrar(Carro carro) {
		
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();


		return carro;
	}

	@Override
	public List<Carro> listar() {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Carro> carros = entityManager.createQuery("from Carro", Carro.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return carros;
	}

	@Override
	public void excluir(Long id) {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Carro carro = entityManager.find(Carro.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
