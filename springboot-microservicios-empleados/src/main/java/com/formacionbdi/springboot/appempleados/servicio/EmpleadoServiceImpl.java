package com.formacionbdi.springboot.appempleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.appempleados.model.Empleado;
import com.formacionbdi.springboot.appempleados.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private EmpleadoRepositorio repositorio;

	@Override
	public List<Empleado> listar() {
	
		return repositorio.findAll();
	}

	@Override
	public void guardar(Empleado e) {
		repositorio.save(e);
		
	}

	@Override
	public void borrar(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
		
	}

	@Override
	public void actualizar(Empleado e) {
		repositorio.saveAndFlush(e);
	
		
	}

	

	
	
}
