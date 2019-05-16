package ba.br.com.intercity.intercitybaservices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.br.com.intercity.intercitybaservices.controller.EmpresasController;
import ba.br.com.intercity.intercitybaservices.entities.Empresa;
import ba.br.com.intercity.intercitybaservices.jsoup.DadosJsoup;


@RestController
public class RoutesController {
	private EmpresasController ep;
	
	@Cacheable(value="locais")
	@RequestMapping(value = "/locais", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String obterLocais() {
		
		return new DadosJsoup().obterContatos().toString();
	}
	
	//@Cacheable(value="empresateste")
	@RequestMapping(value = "/empresas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String obterEmpresa() {
		return new DadosJsoup().obterContatos().toString();
	}
	
	
}
