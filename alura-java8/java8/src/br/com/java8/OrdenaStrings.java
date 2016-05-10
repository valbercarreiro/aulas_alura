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
public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
//		palavras.sort((s1, s2) -> 
//			Integer.compare(s1.length(), s2.length())
//		);
		
//		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
//		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		System.out.println(palavras);
		
//		palavras.forEach(p -> {
//			System.out.println(p);
//		});
		
		palavras.forEach(System.out::println);
		
//		new Thread(() -> {
//		        System.out.println("Executando um Runnable");
//		}).start();
	}

}