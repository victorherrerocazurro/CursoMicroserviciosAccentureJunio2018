package com.curso.microservicios.holamundo;

public class SaludoOut {
	
	private String saludo;
	
	public SaludoOut() {
		super();
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public SaludoOut(String saludo) {
		super();
		this.saludo = saludo;
	}
}
