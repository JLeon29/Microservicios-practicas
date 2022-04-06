package com.formacionbdi.springboot.appproductos.models.repository;


import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.appproductos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
