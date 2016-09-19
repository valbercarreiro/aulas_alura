/**
 * 
 */
package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author Valber Paulino
 *
 */
public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception{
		long millis = System.currentTimeMillis();
		
		Object o = context.proceed();
		String method = context.getMethod().getName();
		String nomeclass = context.getTarget().getClass().getSimpleName();
		
		System.out.println(nomeclass + " - " + method);
		System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millis));
		
		return o;
	}

}
