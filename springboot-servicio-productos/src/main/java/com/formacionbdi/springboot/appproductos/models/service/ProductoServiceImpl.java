package com.formacionbdi.springboot.appproductos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.appproductos.models.entity.Producto;
import com.formacionbdi.springboot.appproductos.models.repository.ProductoDao;

@Service

public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)  // para que se encuentre sincronizada con la BD
	public List<Producto> findAll() {
		
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {
		
		return productoDao.findById(id).orElse(null); // orElse -> sino lo encuentra que devuelva un objeto nulo
	}

}
