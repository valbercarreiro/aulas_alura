package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/form")
	public String formulario() {
		
		
		return "conta/formulario";

	}

	@RequestMapping("/conta/adicionarConta")
	public String adiciona(Conta c){
		System.out.println("Conta adicionada é: "+c.getDescricao());
		ContaDAO dao = new ContaDAO();
		dao.adiciona(c);
		return "conta/conta-adicionada";
	}
}
