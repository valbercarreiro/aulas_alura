/**
 * 
 */
package br.com.gerenciador;

/**
 * @author Valber Paulino
 *
 */
public class TestaCursoComAluno {
	
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com Array List", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		Aluno a1 = new Aluno("Rodrigo Turini",34672);
		Aluno a2 = new Aluno("Guilherme Silveira",5617);
		Aluno a3 = new Aluno("Mauricio Aniche",17645);
		
		javaColecoes.matriculaAluno(a1);
		javaColecoes.matriculaAluno(a2);
		javaColecoes.matriculaAluno(a3);
		
		System.out.println("Todos os alunos matriculados neste curso: ");
		javaColecoes.getAlunos().forEach(aluno -> {System.out.println(aluno);});
		
		System.out.println("O aluno "+a1+" está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini",34672);
		System.out.println("E esse turini, está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		System.out.println("a1 equals turini?");
		System.out.println(a1.equals(turini));
		
		System.out.println(a1.hashCode() == turini.hashCode());
	}

}
