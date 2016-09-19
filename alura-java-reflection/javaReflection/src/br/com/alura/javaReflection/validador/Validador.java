/**
 * 
 */
package br.com.alura.javaReflection.validador;

import java.lang.reflect.Method;

/**
 * @author Valber Paulino
 *
 */
public class Validador {

	public static boolean validarObjeto(Object o) throws Exception {
		boolean result = true;
		
		Class<?> c = o.getClass();
		
		for (Method m : c.getMethods()) {
			if(m.getName().startsWith("test") && m.getReturnType() == boolean.class && m.getParameterTypes().length == 0) {
				Boolean resultado = (Boolean) m.invoke(o);				
				result = result && resultado.booleanValue();
			}
		}
		
		return result;
	}
	
}
