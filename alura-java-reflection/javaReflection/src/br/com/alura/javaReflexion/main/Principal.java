package br.com.alura.javaReflexion.main;

import java.util.List;
import java.util.Map;

import br.com.alura.javaReflexion.mapeia.Mapeador;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		Mapeador m = new Mapeador();
		
		m.load("classes.prop");
		
		List l = m.getInstancia(List.class);

		System.out.println(l.getClass());
		
		System.out.println(m.getImplementacao(List.class));
		System.out.println(m.getImplementacao(Map.class));
	}

}
