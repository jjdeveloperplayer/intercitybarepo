package ba.br.com.intercity.intercitybaservices;

import java.util.List;

import org.jsoup.nodes.Document;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.br.com.intercity.intercitybaservices.entities.Empresa;
import ba.br.com.intercity.intercitybaservices.jsoup.DadosJsoup;


@RestController
public class RoutesController {
	
	@Cacheable(value="locais")
	@RequestMapping(value = "/locais", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String obterLocais() {
		
		return new DadosJsoup().obterContatos().toString();
	}
	
	@Cacheable(value="empresateste")
	@RequestMapping(value = "/empresas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Empresa> obterEmpresa() {
		
		return new DadosJsoup().obterLinhas();
	}
}
