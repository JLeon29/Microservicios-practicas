package com.formacionbdi.springboot.appproductos.models.service;

import java.util.List;

import com.formacionbdi.springboot.appproductos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById( Long id);
	

}
