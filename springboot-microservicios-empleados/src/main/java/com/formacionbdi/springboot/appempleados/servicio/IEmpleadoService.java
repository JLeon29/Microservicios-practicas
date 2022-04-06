package com.formacionbdi.springboot.appempleados.servicio;

import java.util.List;

import com.formacionbdi.springboot.appempleados.model.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> listar();
	public void guardar(Empleado e);
	public void borrar(Integer id);
	public Empleado buscarPorId(Integer id);
	public void actualizar(Empleado e);
	
	

}
