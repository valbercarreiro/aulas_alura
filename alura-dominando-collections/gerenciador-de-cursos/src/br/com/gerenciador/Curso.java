/**
 * 
 */
package br.com.gerenciador;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author Valber Paulino
 *
 */
public class Curso {
	
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>(); 
	
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula){
		this.aulas.add(aula);
	}
	
	public int getTempoTotal(){		
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		return "[Curso: "+this.nome+", Tempo Total: "+getTempoTotal()+", aulas: "+this.aulas+"]";
	}

	public void matriculaAluno(Aluno a) {
		this.alunos.add(a);
		
		this.matriculaParaAluno.put(a.getNumeroMatricula(), a);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno a) {
		return this.alunos.contains(a);
	}

//	public Aluno buscaMatriculado(int i) {
//		for (Aluno aluno : alunos) {
//			if(aluno.getNumeroMatricula() == i){
//				return aluno;
//			}
//		}
//		throw new NoSuchElementException("Matricula " + i + " não encontrada");
//	}
	
	public Aluno buscaMatriculado(int numero) {
		if(this.matriculaParaAluno.get(numero) == null){
			throw new NoSuchElementException("Matricula " + numero + " não encontrada");
		}
		return this.matriculaParaAluno.get(numero);
	}
}
