/**
 * 
 */
package br.com.gerenciador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Valber Paulino
 *
 */
public class TestaAlunos {

	public static void main(String[] args) {
		Set<String> alunos = new HashSet<>();
		
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Sérgio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		
		boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
		System.out.println(pauloEstaMatriculado);
		
		alunos.remove("Sérgio Lopes");
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(alunos.size());
		
		System.out.println("----------------------------------------------------------------------------");
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		System.out.println("----------------------------------------------------------------------------");
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
	}
	
}
