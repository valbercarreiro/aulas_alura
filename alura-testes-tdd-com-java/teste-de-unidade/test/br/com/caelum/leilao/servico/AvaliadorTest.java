package br.com.caelum.leilao.servico;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		//Cria cenário
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 250.00));
		leilao.propoe(new Lance(jose, 300.00));
		leilao.propoe(new Lance(maria, 400.00));
		
		//Executa a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400.00;
		double menorEsperado = 250.00;
		
		//Valida a saída
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		
		//Cria cenário
		Usuario joao = new Usuario("João");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 1000.00));
				
		//Executa a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//Valida a saída
		assertEquals(1000.00, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.00, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveValidarMediaDosLances() {
		
		//Cria cenário
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 250.00));
		leilao.propoe(new Lance(jose, 300.00));
		leilao.propoe(new Lance(maria, 400.00));
		
		//Executa a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double mediaLances = 316.666666666;
		
		//Valida a saída
		assertEquals(mediaLances, leiloeiro.getMediaLances(), 0.00001);
		
	}

	@Test
	public void deveEncontrarOsTresMaioresLances(){
		//Cria cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 100.00));
		leilao.propoe(new Lance(maria, 200.00));
		leilao.propoe(new Lance(joao, 300.00));
		leilao.propoe(new Lance(maria, 400.00));
		
		//Executa a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	}
	
	@Test
    public void deveEntenderLeilaoComLancesEmOrdemRandomica() {
        Usuario joao = new Usuario("Joao"); 
        Usuario maria = new Usuario("Maria"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,200.0));
        leilao.propoe(new Lance(maria,450.0));
        leilao.propoe(new Lance(joao,120.0));
        leilao.propoe(new Lance(maria,700.0));
        leilao.propoe(new Lance(joao,630.0));
        leilao.propoe(new Lance(maria,230.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
    }
}
