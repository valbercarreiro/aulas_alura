/**
 * 
 */
package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.conf.JPAConfiguration;
import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

/**
 * @author Valber Paulino
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JPAConfiguration.class, ProdutoDAO.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Test
	@Transactional
	public void deveSomarTodosPrecosPorTipoLivro(){
		
		List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).mais(3).buildAll();
		
		List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).mais(3).buildAll();
		
//		List<Produto> livrosCombo = ProdutoBuilder.newProduto(TipoPreco.COMBO, BigDecimal.TEN).mais(3).buildAll();
		
		livrosImpressos.forEach(produtoDao::gravar);
		livrosEbook.forEach(produtoDao::gravar);
		
		BigDecimal valorImpresso = produtoDao.somaPrecosPorTipoPreco(TipoPreco.IMPRESSO);
		Assert.assertEquals(new BigDecimal(404).setScale(2), valorImpresso);
		
		BigDecimal valorEbook = produtoDao.somaPrecosPorTipoPreco(TipoPreco.EBOOK);
		Assert.assertEquals(new BigDecimal(354).setScale(2), valorEbook);
	}

}
