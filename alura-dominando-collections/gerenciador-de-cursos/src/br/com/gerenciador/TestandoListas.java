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
public class TestandoListas {
	
	public static void main(String[] args) {
		String aula1 = "Java 8: Tire proveito dos novos recursos da linguagem";
        String aula2 = "Bootstrap: velocidade no front-end";
        String aula3 = "Angular JS: crie webapps poderosas";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);        

        System.out.println(aulas);
        
        aulas.remove(0);
        
        System.out.println(aulas);
        
        for (String aula : aulas) {
			System.out.println("Aula: "+aula);
		}
        
        String primeiraAula = aulas.get(0);
        System.out.println("A primeira aula é: "+primeiraAula);
        
		aulas.forEach(aula -> {
			System.out.println("percorrendo :" + aula);
		});	
		
		aulas.add("Aumentando nosso conhecimento");
		System.out.println(aulas);
		Collections.sort(aulas);
		System.out.println("Depois de ordenado: "+aulas);
		
		for(int i=0; i <= aulas.size(); i++){
			System.out.println(aulas.get(i));
		}
	}

}
