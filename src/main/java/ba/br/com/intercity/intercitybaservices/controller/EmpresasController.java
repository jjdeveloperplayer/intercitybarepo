package ba.br.com.intercity.intercitybaservices.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
	
	public EmpresasController(EmpresaRepository empresaRepository) {
		this.repository = empresaRepository;
	}
	
	@GetMapping
	public List findAll(){
	  return repository.findAll();
	}
	
	@GetMapping
	public List<Empresa> chamarEmpresas(){
	   return repository.saveAll(obterLinhas());
	}
	
	public List<Empresa> obterLinhas(){
		Document doc = conectar("http://www.agerba.ba.gov.br/transporte/prestadora_servico.asp");
		Elements tables = doc.select("table[cellpadding=3]");
		
		List<Empresa> listaTeste = new ArrayList<>();//Teste empresas
		for(Element tb: tables) {
			Elements trs = tb.select("tr");
			//Preencher dados da empresa
			Empresa emp = new Empresa();
			emp.setNomeOficial(trs.get(0).select("td").get(1).text());
			emp.setNomeFantasia(trs.get(1).select("td").get(1).text());
			listaTeste.add(emp);
		}
		return listaTeste;
	}
	
	public /*List<Contato>*/ Document obterContatos() {
		Document doc = conectar("http://www.agerba.ba.gov.br/transporte/prestadora_servico.asp");
		
		return doc;
	}
	
	
	public Document conectar(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
