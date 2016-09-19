/**
 * 
 */
package br.com.caelum.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Valber Paulino
 *
 */
@Singleton
@Startup
public class Agendador {
	
	@Schedule(hour="*", minute="*", second="*/10", persistent=false)
	void agendado(){
		System.out.println("verificando serviço externo periodicamente");
	}

}
