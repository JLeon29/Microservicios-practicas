package com.formacionbdi.springboot.appsede.servicio;

import java.util.List;

import com.formacionbdi.springboot.appsede.model.Sede;

public interface ISedeServicio {
	
	public List<Sede> listar();
	public Sede buscarPorId(Integer id, String nombre);

}
