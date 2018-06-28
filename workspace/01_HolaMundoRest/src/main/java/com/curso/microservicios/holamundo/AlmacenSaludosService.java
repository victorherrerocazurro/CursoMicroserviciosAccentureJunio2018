package com.curso.microservicios.holamundo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "almacensaludos")
public interface AlmacenSaludosService {

	@RequestMapping(path="/Saludos/{tipo}", method=RequestMethod.GET)
	public SaludoIn saludos(@PathVariable(name="tipo") String tipo);

}
