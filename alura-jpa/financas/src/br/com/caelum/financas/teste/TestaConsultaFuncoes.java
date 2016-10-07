package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsultaFuncoes {

    public static void main(String[] args) {

        EntityManager manager = JPAUtil.getEntityManager();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDAO movDao = new MovimentacaoDAO(manager);
        
        Double bd = movDao.mediaDaContaPorTipo(conta, TipoMovimentacao.ENTRADA);
        
        System.out.println(bd);

    }
}