package com.formacionbdi.springboot.appsede.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.appsede.clientes.EmpleadoClienteRest;
import com.formacionbdi.springboot.appsede.model.Empleado;
import com.formacionbdi.springboot.appsede.model.Sede;

@Service("servicioFeign")
@Primary
public class SedeServiceFeign implements ISedeServicio {

	@Autowired
	private EmpleadoClienteRest clienteFeign;
	
	@Override
	public List<Sede> listar() {
	List<Empleado> listaEmpleados = clienteFeign.listar();
	
		return listaEmpleados.stream().map(e -> new Sede(e,null)).collect(Collectors.toList());
	}

	@Override
	public Sede buscarPorId(Integer id, String nombre) {
		
		Empleado empleado = clienteFeign.buscarPordId(id);
		return new Sede(empleado,nombre);
	}

}
