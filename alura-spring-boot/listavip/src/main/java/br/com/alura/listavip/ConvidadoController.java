package br.com.alura.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService service;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaConvidados")
	public String listaConvidados(Model model){
		Iterable<Convidado> convidados = service.findAll();
		
		model.addAttribute("convidados", convidados);
		return "listaConvidados";
	}

	@RequestMapping(value="salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone, Model model){
		Convidado c = new Convidado(nome, email, telefone);
		
		service.save(c);
		
		Iterable<Convidado> convidados = service.findAll();
		
		model.addAttribute("convidados", convidados);
		return "listaConvidados";
	}
}
