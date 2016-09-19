/**
 * 
 */
package br.com.gerenciador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Valber Paulino
 *
 */
public class TestaCurso2 {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com Array List", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

		List<Aula> aulas = new ArrayList<>(javaColecoes.getAulas());
		System.out.println(aulas);
		
		Collections.sort(aulas);
//		aulas.sort(java.util.Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
		
		System.out.println(javaColecoes.getTempoTotal());

		System.out.println(javaColecoes);
	}
	
}
