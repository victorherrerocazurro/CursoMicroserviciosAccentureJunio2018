package com.curso.microservicios.saludos;

public class Saludo {
	
	private String prefijo;
	private String sufijo;
	private String nombre;
	
	public Saludo() {
		super();
	}
	public Saludo(String prefijo, String sufijo, String nombre) {
		super();
		this.prefijo = prefijo;
		this.sufijo = sufijo;
		this.nombre = nombre;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getSufijo() {
		return sufijo;
	}
	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
