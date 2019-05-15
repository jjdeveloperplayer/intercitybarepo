package ba.br.com.intercity.intercitybaservices;

import org.jsoup.nodes.Document;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.br.com.intercity.intercitybaservices.jsoup.DadosJsoup;


@RestController
public class RoutesController {
	
	@Cacheable(value="locais")
	@RequestMapping(value = "/locais", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Document obterLocais() {
		
		return new DadosJsoup().obterContatos();
	}
}
