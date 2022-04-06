package com.formacionbdi.springboot.appsede.model;

import java.io.Serializable;

public class Empleado implements Serializable {
	

	private static final long serialVersionUID = 7136118795475837676L;
	
	private Integer id;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer numeroDNI;
	private Integer telefono;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public Integer getNumeroDNI() {
		return numeroDNI;
	}
	public void setNumeroDNI(Integer numeroDNI) {
		this.numeroDNI = numeroDNI;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}
