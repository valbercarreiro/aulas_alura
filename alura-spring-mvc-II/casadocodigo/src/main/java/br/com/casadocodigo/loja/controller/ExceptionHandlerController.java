/**
 * 
 */
package br.com.casadocodigo.loja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Valber Paulino
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public ModelAndView trataExceptionGenerica(Exception exception){
		exception.printStackTrace();
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", exception);
		return mv;
	}
	
}
