package com.formacionbdi.springboot.appempleados.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.appempleados.model.Empleado;
import com.formacionbdi.springboot.appempleados.servicio.IEmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService servicio;

	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<Empleado>> listar() {

		return new ResponseEntity<List<Empleado>>(servicio.listar(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/buscar/{id}")
	public ResponseEntity<Empleado> buscarPorId(@PathVariable Integer id) {

		return new ResponseEntity<Empleado>(servicio.buscarPorId(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Empleado empleado) {
		if (empleado != null) {
			servicio.guardar(empleado);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		if(id != null) {
			servicio.borrar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(method = RequestMethod.PUT, path = "/actualizar")
	public ResponseEntity<Void> actualizar(@RequestBody Empleado empleado) {

		if (empleado != null) {
			servicio.actualizar(empleado);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

}
