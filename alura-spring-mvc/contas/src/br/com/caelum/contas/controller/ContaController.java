package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	private ContaDAO dao;

	@Autowired
	public ContaController(ContaDAO dao){
		this.dao = dao;
	}

	@RequestMapping("/form")
	public String formulario() {
		
		
		return "conta/formulario";

	}

	@RequestMapping("/adicionarConta")
	public String adiciona(@Valid Conta c, BindingResult result){
		
		if(result.hasFieldErrors()){
			return "conta/formulario";
		}
		
		System.out.println("Conta adicionada é: "+c.getDescricao());
		
		dao.adiciona(c);
//		return "conta/conta-adicionada";
		return "redirect:listaContas";
	}
	
//	@RequestMapping("/listaContas")
//	public ModelAndView lista(){
//		ContaDAO dao = new ContaDAO();
//		List<Conta> contas = dao.lista();
//		
//		ModelAndView mv = new ModelAndView("conta/lista");
//		mv.addObject("todasContas", contas);
//		
//		return mv;
//	}
	@RequestMapping("/listaContas")
	public String lista(Model mv){
		
		List<Conta> contas = dao.lista();
		
		mv.addAttribute("todasContas", contas);
		
		return "conta/lista";
	}
	
	@RequestMapping("/removerConta")
	public String removeConta(Conta conta){
		dao.remove(conta);
		
		return "redirect:listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
	  model.addAttribute("conta", dao.buscaPorId(id));
	  return "conta/mostra";
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		dao.altera(conta);
		return "redirect:listaContas";
	}
	
	@RequestMapping("/pagaConta")
	public void paga(Conta conta, HttpServletResponse resp) {
	  dao.paga(conta.getId());
	  resp.setStatus(200);
	}
}
