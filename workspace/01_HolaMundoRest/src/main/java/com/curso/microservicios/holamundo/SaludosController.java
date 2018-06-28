package com.curso.microservicios.holamundo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Saludos")
@RefreshScope
public class SaludosController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AlmacenSaludosService almacenSaludos;
	
	@GetMapping("/hola")
	public ResponseEntity<SaludoOut> hola(
			@RequestParam(name="name", required=false, defaultValue="World") String name) {
		
		//Map<String, String> uriVariables = new HashMap<>();
		//uriVariables.put("tipo", "hola");
		
		//SaludoIn response = restTemplate.getForObject("http://almacensaludos/Saludos/{tipo}", SaludoIn.class, uriVariables);
		
		SaludoIn response = almacenSaludos.saludos("hola");
		
		String saludo = response.getPrefijo() + " " + name + response.getSufijo();
		
		return new ResponseEntity<SaludoOut>(new SaludoOut(saludo), HttpStatus.OK);

	}

	@PostMapping("/adios")
	public ResponseEntity<Void> adios(@RequestBody SaludoIn saludo) {
		System.out.println(saludo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Value("${message:Hola Mundo!!!}")
	private String mensaje;
	
	@GetMapping("/holaMundo")
	public ResponseEntity<SaludoOut> holaMundo() {
		return new ResponseEntity<SaludoOut>(new SaludoOut(mensaje), HttpStatus.OK);

	}


}
