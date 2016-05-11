/**
 * 
 */
package br.com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Valber Paulino
 *
 */
class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAlunos() {
		return alunos;
	}
	
}

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python",45));
		cursos.add(new Curso("Javascript",150));
		cursos.add(new Curso("Java8",113));
		cursos.add(new Curso("C",55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
//			.forEach(c -> System.out.println(c.getNome()));
//			.map(c -> c.getAlunos())
//			.forEach(System.out::println);
			.mapToInt(Curso::getAlunos)
			.sum();
		
		System.out.println(sum);
		
		System.out.println(cursos.stream().findFirst().get().getNome());
	}
}
