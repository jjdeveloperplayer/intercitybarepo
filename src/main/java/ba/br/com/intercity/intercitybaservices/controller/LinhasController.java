package ba.br.com.intercity.intercitybaservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.br.com.intercity.intercitybaservices.entities.Linha;
import ba.br.com.intercity.intercitybaservices.repository.LinhaRepository;

@RestController
@RequestMapping({"/linhas"})
public class LinhasController {
	private LinhaRepository repository;
	
	@PostMapping
	public List<Linha> salvarLinha(@RequestBody List<Linha> linhas){
	   return repository.saveAll(linhas);
	}
}
