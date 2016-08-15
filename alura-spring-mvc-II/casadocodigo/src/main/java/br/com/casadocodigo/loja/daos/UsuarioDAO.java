/**
 * 
 */
package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

/**
 * @author valbercarreiro
 *
 */
@Repository
public class UsuarioDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	public Usuario loadUserByUsername(String email){
		List<Usuario> lista = manager.createQuery("Select u From Usuario u Where u.email = :email")
				.setParameter("email", email)
				.getResultList();
		
		if(lista.isEmpty()){
			throw new UsernameNotFoundException("Usuário "+ email + "não foi encontrado");
		}
		
		return lista.get(0);
	}
}
