package br.com.caelum.financas.main;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJpa {
	
	public static void main(String[] args) {
		Conta c = new Conta();
		c.setTitular("Teste");
		c.setBanco("Banco do Brasil");
		c.setAgencia("0151");
		c.setNumero("33265");
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas-postgres");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();;
		
		entityManager.persist(c);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}
