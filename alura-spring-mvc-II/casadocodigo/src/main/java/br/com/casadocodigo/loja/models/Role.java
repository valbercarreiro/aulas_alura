/**
 * 
 */
package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author valbercarreiro
 *
 */
//insert into Role values ('ROLE_ADMIN');
@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 7872503757574608017L;
	
	@Id
	private String nome;

	public Role(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}
}