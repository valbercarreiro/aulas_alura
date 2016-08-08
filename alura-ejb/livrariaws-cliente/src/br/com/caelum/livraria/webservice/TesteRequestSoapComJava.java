/**
 * 
 */
package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

/**
 * @author Valber Paulino
 *
 */
public class TesteRequestSoapComJava {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {

		LivrariaWS cliente = new LivrariaWSProxy();
		
		Livro[] livros = cliente.getLivrosPeloNome("Arquitetura");
		
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor().getNome());
		}

	}

}
