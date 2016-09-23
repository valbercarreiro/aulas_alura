package br.com.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> findAll(){
		return repository.findAll();
	}
	
	public void save(Convidado c){
		repository.save(c);
		new EmailService().enviar(c.getNome(), c.getEmail());
	}
}
