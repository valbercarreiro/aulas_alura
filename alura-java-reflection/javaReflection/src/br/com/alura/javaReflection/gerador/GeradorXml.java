/**
 * 
 */
package br.com.alura.javaReflection.gerador;

import java.lang.reflect.Field;

/**
 * @author Valber Paulino
 *
 */
public class GeradorXml {
	
	public static String getXML(Object obj) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		Class<?> c = obj.getClass();
		sb.append("<"+c.getSimpleName()+">\n");
		
		for (Field f : c.getDeclaredFields()) {
			sb.append("<"+f.getName()+">");
			f.setAccessible(true); //Para liberar o acesso aos membros privados
			sb.append(f.get(obj));
			sb.append("</"+f.getName()+">\n");
		}
		
		sb.append("</"+c.getSimpleName()+">\n");
		return sb.toString();
	}

}
