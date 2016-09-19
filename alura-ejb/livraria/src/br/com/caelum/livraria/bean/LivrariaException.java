/**
 * 
 */
package br.com.caelum.livraria.bean;

import javax.ejb.ApplicationException;

/**
 * @author Valber Paulino
 *
 */
@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {

	private static final long serialVersionUID = -2492727106330660361L;

}
