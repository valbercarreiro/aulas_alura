/**
 * 
 */
package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

/**
 * @author Valber Paulino
 *
 */
@Stateless
public class AutorService {

	@Inject
	AutorDao autorDao;
	
	public void adiciona(Autor autor) {
		//mais regras aqui
		
		autorDao.salva(autor);
		
		throw new LivrariaException();
	}
	
	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}
}
