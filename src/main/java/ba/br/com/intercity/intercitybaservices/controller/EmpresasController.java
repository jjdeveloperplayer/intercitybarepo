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

import ba.br.com.intercity.intercitybaservices.entities.Contato;
import ba.br.com.intercity.intercitybaservices.entities.Empresa;
import ba.br.com.intercity.intercitybaservices.repository.EmpresaRepository;

@RestController
@RequestMapping({ "/empresas" })
public class EmpresasController {
	private EmpresaRepository repository;

	public EmpresasController(EmpresaRepository empresaRepository) {
		this.repository = empresaRepository;
	}

	/*
	 * @GetMapping public List findAll(){ return repository.findAll(); }
	 */
	@GetMapping
	public List<Empresa> chamarEmpresas() {
		return repository.saveAll(obterLinhas());
	}

	public List<Empresa> obterLinhas() {
		Document docEmpresas = conectar("http://www.agerba.ba.gov.br/transporte/prestadora_servico.asp");
		Elements tables = docEmpresas.select("table[cellpadding=3]");

		// Pag de contatos
		Document pageContatos = conectar("http://www.agerba.ba.gov.br/projeto/ouvidoria/");
		Elements tablescontatos = pageContatos.select("table");
		ArrayList<Empresa> empresaTmp = new ArrayList<>(); // guardar temporariamente

		for (Element tb : tablescontatos) {
			Elements trs = tb.select("tr");
			trs.remove(0);
			for (Element tr : trs) {
				Empresa tmp = new Empresa();
				tmp.setContatos(new ArrayList<>());
				String text = tr.html();
				String[] textSplitResult = text.split("<br>");
				if (null != textSplitResult) {
					for (String t : textSplitResult) {
						String[] dados = text.split(":");
						if (dados.length >0) {
							if (textSplitResult[0].equals(t)) {
								tmp.setNomeOficial(dados[1]);
							} else {
								Contato c = new Contato();
								c.setTipoContato(dados[0]);
								c.setConteudo(dados[1]);
								tmp.getContatos().add(c);
							}
						}
					}
				}
				empresaTmp.add(tmp);
			}
		}

		List<Empresa> listaTeste = new ArrayList<>();// Teste empresas
		for (Element tb : tables) {
			Elements trs = tb.select("tr");
			// Preencher dados da empresa
			Empresa emp = new Empresa();
			emp.setNomeOficial(trs.get(0).select("td").get(1).text());
			emp.setNomeFantasia(trs.get(1).select("td").get(1).text());
			
			boolean possui = false;
			for (Empresa e : empresaTmp) {
				if (e.getNomeOficial().contains(emp.getNomeFantasia())) {
					emp.setContatos(e.getContatos());
					possui = true;
				}
			}
			if(possui) listaTeste.add(emp);
		}
		return listaTeste;
	}

	public /* List<Contato> */ Document obterContatos() {
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
