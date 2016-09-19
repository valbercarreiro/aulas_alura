package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto){
		manager.persist(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("Select distinct p From Produto p join fetch p.precos preco", Produto.class).getResultList();
	}

	public Produto find(Integer id) {
		return manager.createQuery("Select distinct(p) From Produto p join fetch p.precos preco where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somaPrecosPorTipoPreco(TipoPreco tipoPreco){
		TypedQuery<BigDecimal> query = manager.createQuery("Select sum(preco.valor) From Produto p join p.precos preco Where preco.tipo = :tipoPreco", BigDecimal.class);
		query.setParameter("tipoPreco", tipoPreco);
		
		return query.getSingleResult();
	}
}
