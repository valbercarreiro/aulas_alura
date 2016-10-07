package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {
	
	private EntityManager manager;
	
	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Double mediaDaContaPorTipo(Conta conta, TipoMovimentacao tipo){
//      TypedQuery<BigDecimal> query = manager
//		.createQuery("select sum(m.valor) from Movimentacao m where m.conta = :pConta"
//				+ " and m.tipoMovimentacao = :pTipo", BigDecimal.class);

		TypedQuery<Double> query = manager.createNamedQuery("mediaContaTipoMovimentacao", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		Double bd = query.getSingleResult();
		
		return bd;
	}

}
