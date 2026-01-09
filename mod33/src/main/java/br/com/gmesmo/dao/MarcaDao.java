package br.com.gmesmo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gmesmo.domain.Marca;

public class MarcaDao implements IMarcaDao {

	@Override
	public Marca cadastrar(Marca marca) {
		
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(marca);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();


		return marca;
	}

	@Override
	public List<Marca> listar() {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Marca> marcas = entityManager.createQuery("from Marca", Marca.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return marcas;
	}

	@Override
	public void excluir(Long id) {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Marca marca = entityManager.find(Marca.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(marca);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
