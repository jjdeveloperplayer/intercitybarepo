package ba.br.com.intercity.intercitybaservices.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ba.br.com.intercity.intercitybaservices.controller.EmpresasController;
import ba.br.com.intercity.intercitybaservices.entities.Empresa;


public class DadosJsoup {

	
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
		return null;//ep.salvarEmpresas(listaTeste);
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
