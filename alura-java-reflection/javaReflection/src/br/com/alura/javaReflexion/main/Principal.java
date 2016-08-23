package br.com.alura.javaReflexion.main;

import br.com.alura.javaReflexion.models.UsuarioXml;
import br.com.alura.javaReflexion.validador.Validador;

public class Principal {

	public static void main(String[] args) throws Exception {
		
//		Mapeador m = new Mapeador();
//		
//		m.load("classes.prop");
//		
//		List l = m.getInstancia(List.class);
//
//		System.out.println(l.getClass());
//		
//		System.out.println(m.getImplementacao(List.class));
//		System.out.println(m.getImplementacao(Map.class));
		
//		UsuarioXml u = new UsuarioXml();
//		u.setLogin("gerra");
//		u.setSenha("senhadoguerra");
//		u.setEmail("guerra@guerra.com");
//		u.setPapel("Professor");
//		u.setAtivo(true);
		
//		String xml = GeradorXml.getXML(u);
//		System.out.println(xml);
		
		UsuarioXml u = new UsuarioXml();
		u.setLogin("reflection");
		u.setSenha("senhadoguerra");
		u.setEmail("guerra@guerra.com");
		
		boolean valido = Validador.validarObjeto(u);
		if(valido){
			System.out.println("O objeto é válido.");
		} else {
			System.out.println("O objeto é INválido.");
		}
	}

}
