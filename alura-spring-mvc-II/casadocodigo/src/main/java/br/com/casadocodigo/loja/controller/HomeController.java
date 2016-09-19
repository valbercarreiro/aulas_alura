package br.com.casadocodigo.loja.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@RequestMapping("/")
	@Cacheable(value="produtosHome")
	public ModelAndView index(){
		List<Produto> lista = produtoDao.listar();
		ModelAndView model = new ModelAndView("home");
		model.addObject("produtos", lista);
		return model;
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/url-magica-maluca-asdasasdfasd08098023424lnlknlsdfsda4asdfasd")
	public String urlMagicaMaluca(){
		Usuario usuario = new Usuario();
		usuario.setNome("admin");
		usuario.setEmail("admin@casadocodigo.com.br");
		usuario.setSenha("$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq");
		usuario.setPermissoes(Arrays.asList(new Role("ROLE_ADMIN")));
		
		usuarioDao.grava(usuario);
		
		return "Url mágica executada";
	}
}
