package ba.br.com.intercity.intercitybaservices;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoutesController {

	@Cacheable(value="locais")
	@RequestMapping(value = "/locais", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String obterLocais() {

		return "Salvador BAHIA Brasil";
	}
}
