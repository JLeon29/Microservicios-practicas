package com.formacionbdi.springboot.appsede.model;

import java.io.Serializable;

public class Sede implements Serializable {
	

	private static final long serialVersionUID = 830526721403591423L;
	
	private Empleado empleado;
	private String nombre;
	
	
	
	public Sede() {
		super();
	}
	public Sede(Empleado empleado, String nombre) {
		super();
		this.empleado = empleado;
		this.nombre = nombre;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
	

}
