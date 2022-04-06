package com.formacionbdi.springboot.appitem.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.appitem.models.Producto;

@FeignClient(name="servicio-productos", url = "localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("producto/listar")
	public List<Producto> listar();
	
	@GetMapping("producto/ver/{id}")
	public Producto detalle(@PathVariable Long id);

}