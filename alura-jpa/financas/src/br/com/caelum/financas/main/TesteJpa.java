package br.com.caelum.financas.main;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJpa {
	
	public static void main(String[] args) {
		Conta c = new Conta();
//		c.setTitular("Teste");
//		c.setBanco("Banco do Brasil");
//		c.setAgencia("0151");
//		c.setNumero("33265");
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();;
		
//		entityManager.persist(c);
		c = entityManager.find(Conta.class, 1);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}
