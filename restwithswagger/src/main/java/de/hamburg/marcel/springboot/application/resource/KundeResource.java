package de.hamburg.marcel.springboot.application.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hamburg.marcel.springboot.application.model.Kunde;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/kunde")
@Api
public class KundeResource {

	@ApiOperation(value = "suche nach einem kunden")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")

	public Kunde findBy(@RequestParam(value = "test") String name) {
		Kunde k = new Kunde();
		k.setVorname(name);
		return k;
	}
}
