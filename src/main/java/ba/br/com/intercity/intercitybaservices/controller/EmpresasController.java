package ba.br.com.intercity.intercitybaservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.br.com.intercity.intercitybaservices.entities.Empresa;
import ba.br.com.intercity.intercitybaservices.repository.EmpresaRepository;


@RestController
@RequestMapping({"/empresas"})
public class EmpresasController {
	private EmpresaRepository repository;
	
	@GetMapping
	public List findAll(){
	  return repository.findAll();
	}
	
	@PostMapping
	public List<Empresa> salvarEmpresas(@RequestBody List<Empresa> empresas){
	   return repository.saveAll(empresas);
	}
}
