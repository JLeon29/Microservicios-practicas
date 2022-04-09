package com.formacionbdi.springboot.appproductos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.appproductos.models.entity.Producto;
import com.formacionbdi.springboot.appproductos.models.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	//Se utiliza con Feign
	@Autowired
	private Environment env; // mediante esta variable podemos obtener el puerto
	
	//Se utiliza con RestTemplate, para obtener el puerto
	@Value("${server.port}")
	private Integer port;
	
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		
		return productoService.findAll().stream().map(producto ->{
			// producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); --- obtener el puerto con Feign - Enviroment
			producto.setPort(port); // obtener el puerto con RestTemplate
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		
		 
		Producto producto = productoService.findById(id);
		//Devuelve el puerto por Feign
		// producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));---  obtener el puerto con Feign - Enviroment
		producto.setPort(port); // obtener el puerto con RestTemplate
		return productoService.findById(id);
		
		
	}

}
