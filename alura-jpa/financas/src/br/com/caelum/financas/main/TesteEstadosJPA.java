package br.com.caelum.financas.main;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

  public static void main(String[] args) {

		EntityManager manager = JPAUtil.getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo

		manager.getTransaction().commit();

		manager.close();

	}
}