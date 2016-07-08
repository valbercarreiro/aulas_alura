package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/loginForm")
	public String formulario() {
		return "usuario/login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario user, HttpSession session) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(usuarioDAO.existeUsuario(user)){
			session.setAttribute("usuarioLogado", user);
			return "menu";
		}
		return "redirect:loginForm";
	}

	@RequestMapping("/efetuaLogout")
	public String efetuaLogout(HttpSession session) {
		session.invalidate();
		
		return "redirect:loginForm";
	}

}
