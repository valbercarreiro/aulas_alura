/**
 * 
 */
package br.com.gerenciador;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Valber Paulino
 *
 */
public class TestaListaDeAula {

	public static void main(String[] args) {
		Aula a1 = new Aula("Revisitando Array List", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		
		Collections.sort(aulas);
		
		System.out.println(aulas);
		
		aulas.sort(java.util.Comparator.comparing(Aula::getTempo));
		
		System.out.println(aulas);
	}

}