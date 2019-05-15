package ba.br.com.intercity.intercitybaservices.jsoup;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import ba.br.com.intercity.intercitybaservices.entities.Contato;

public class DadosJsoup {
	
	public /*List<Contato>*/ Document obterContatos() {
		Document doc = conectar("http://www.agerba.ba.gov.br/projeto/ouvidoria/");
		
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
