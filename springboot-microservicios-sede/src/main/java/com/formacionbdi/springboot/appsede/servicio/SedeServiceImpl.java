package com.formacionbdi.springboot.appsede.servicio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.appsede.model.Empleado;
import com.formacionbdi.springboot.appsede.model.Sede;

@Service
public class SedeServiceImpl implements ISedeServicio {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Sede> listar() {
		List<Empleado> listaEmpleados = Arrays.asList(clienteRest.getForObject("http://localhost:8005/empleado/listar", Empleado[].class));
		
		
		return listaEmpleados.stream().map(e -> new Sede(e,null)).collect(Collectors.toList());
	}

	@Override
	public Sede buscarPorId(Integer id, String nombre) {
		
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		Empleado empleado = clienteRest.getForObject("http://localhost:8005/empleado/buscar/{id}", Empleado.class, pathVariables);
		
		return new Sede(empleado, nombre);
	}

}
