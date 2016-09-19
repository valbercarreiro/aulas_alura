/**
 * 
 */
package br.com.gerenciador;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Valber Paulino
 *
 */
public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {
//		Curso javaColecoes = new Curso("Dominando as coleções do java", "Paulo Silveira");
//		
//		javaColecoes.adiciona(new Aula("Trabalhando com Array List", 21));
//		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
//		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
//		
//		Aluno a1 = new Aluno("Rodrigo Turini",34672);
//		Aluno a2 = new Aluno("Guilherme Silveira",5617);
//		Aluno a3 = new Aluno("Mauricio Aniche",17645);
//		
//		javaColecoes.matriculaAluno(a1);
//		javaColecoes.matriculaAluno(a2);
//		javaColecoes.matriculaAluno(a3);
//		
//		System.out.println("Quem é o aluno com matricula 5617?");
//		Aluno a = javaColecoes.buscaMatriculado(5617);
//		System.out.println("O aluno é: "+a);
		
		Map<Integer, String> pessoas = new HashMap<>();

		pessoas.put(21, "Leonardo Cordeiro");
		pessoas.put(27, "Fabio Pimentel");
		pessoas.put(19, "Silvio Mattos");
		pessoas.put(23, "Romulo Henrique");
		
		pessoas.keySet().forEach(idade -> {
			System.out.println(pessoas.get(idade));
		});
		System.out.println("----------------------------");
		pessoas.values().forEach(str -> {
			System.out.println(str);
		});
		
	}
}
