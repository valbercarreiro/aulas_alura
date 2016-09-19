package br.com.alura.javaReflection.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.alura.javaReflection.models.UsuarioXml;
import br.com.alura.javaReflection.validador.Validador;

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
		
//		UsuarioXml u = new UsuarioXml();
//		u.setLogin("reflection");
//		u.setSenha("senhadoguerra");
//		u.setEmail("guerra@guerra.com");
//		
//		boolean valido = Validador.validarObjeto(u);
//		if(valido){
//			System.out.println("O objeto é válido.");
//		} else {
//			System.out.println("O objeto é INválido.");
//		}
		
		TesteErros obj = new TesteErros();
		Class<?> c = obj.getClass();
		
		try {
			Method m = c.getDeclaredMethod("metodo", String.class);
			m.invoke(obj);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
