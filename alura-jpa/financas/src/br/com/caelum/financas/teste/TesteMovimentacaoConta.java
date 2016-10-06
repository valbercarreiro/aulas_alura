package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

    public static void main(String[] args) {
    	
    	EntityManager manager = JPAUtil.getEntityManager();
    	
//    	Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
//    	
//    	System.out.println("Titular da conta: " + movimentacao.getConta().getTitular()); 
    	
//        Conta conta = manager.find(Conta.class, 2);
    	
    	Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :idConta");
    	query.setParameter("idConta", 2);
    	Conta conta = (Conta) query.getSingleResult();

        System.out.println(conta.getMovimentacoes().size()); 
    }
}