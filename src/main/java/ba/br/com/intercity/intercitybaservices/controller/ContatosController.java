package ba.br.com.intercity.intercitybaservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.br.com.intercity.intercitybaservices.entities.Contato;
import ba.br.com.intercity.intercitybaservices.repository.ContatoRepository;

@RestController
@RequestMapping({"/contatos"})
public class ContatosController {
	private ContatoRepository repository;

	public ContatosController(ContatoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List findAll(){
	  return repository.findAll();
	}
	
	@PostMapping
	public List<Contato> salvarContato(@RequestBody List<Contato> contatos){
	   return repository.saveAll(contatos);
	}
}
