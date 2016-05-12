/**
 * 
 */
package br.com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
		cursos.add(new Curso("Java 8",113));
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
		
//		System.out.println(sum);
//		
//		cursos.stream()
//		.filter(c -> c.getAlunos() >= 100)
//		.findAny()
//		.ifPresent(c -> System.out.println(c.getNome()));
//		
//		cursos = cursos.stream()
//		.filter(c -> c.getAlunos() >= 100)
//		.collect(Collectors.toList());
//		
//		cursos.stream().forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(), 
					c -> c.getAlunos()))
			.forEach((nome,alunos) -> System.out.println(nome + " tem "+alunos+" alunos."));
		
		OptionalDouble average = cursos.stream()
		.mapToInt(Curso::getAlunos)
		.average();
		System.out.println(average.getAsDouble());
	}
}
