package com.formacionbdi.springboot.appempleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.springboot.appempleados.model.Empleado;

@Repository 
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

}
