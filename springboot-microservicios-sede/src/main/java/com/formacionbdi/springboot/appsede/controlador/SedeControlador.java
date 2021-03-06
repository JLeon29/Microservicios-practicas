package com.formacionbdi.springboot.appsede.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.appsede.model.Sede;
import com.formacionbdi.springboot.appsede.servicio.ISedeServicio;

@RestController
@RequestMapping("/sede")
public class SedeControlador {
	
	@Autowired
	@Qualifier("servicioFeign")
	private ISedeServicio servicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Sede>> listar(){
		
		return new ResponseEntity<List<Sede>>(servicio.listar(),HttpStatus.OK);
		
	}
	
	@GetMapping("/buscar/{id}/nombre/{nombre}")
	public ResponseEntity<Sede> buscarPorId(@PathVariable Integer id, @PathVariable String nombre){
		
		return new ResponseEntity<Sede>(servicio.buscarPorId(id, nombre),HttpStatus.OK);
	}
	
	
	

}
