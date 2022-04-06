package com.formacionbdi.springboot.appsede.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.appsede.model.Empleado;

@FeignClient(name= "servicio-empleados", url = "localhost:8005")
public interface EmpleadoClienteRest {
	
	@GetMapping("empleado/listar")
	public List<Empleado> listar();
	
	@GetMapping("empleado/buscar/{id}")
	public Empleado buscarPordId(@PathVariable Integer id);

}
