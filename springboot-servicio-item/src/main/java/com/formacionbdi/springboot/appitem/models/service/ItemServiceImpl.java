package com.formacionbdi.springboot.appitem.models.service;

import java.awt.ItemSelectable;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.appitem.models.Item;
import com.formacionbdi.springboot.appitem.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		// a traves de "clienteRest.getForObject obtenemos el objeto a traves de la ruta y el tipo en un arreglo que luego lo convertimos a List
		// Se va a obtener el producto del otro proyecto y se almacena en una lista
		//List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/producto/listar", Producto[].class));
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/producto/listar", Producto[].class));
		//Transformar una lista de productos (del otro proyecto) a una lista de items (de este proyecto) mediante lambda
		/* stream: para convertir la lista en un flujo
		 * map: para cambiar cada elemento del flujo, cada objeto
		 * collect : convertir a un tipo List
		 * Collector.toList para convertir en un tipo list
		*/
		return productos.stream().map(p-> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		
		//Creamos el map para pasarle el paramatro id
		Map<String,String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		//Producto producto = clienteRest.getForObject("http://localhost:8001/producto/ver/{id}", Producto.class, pathVariables /*en este campo se pasan los parámetros*/); 
		Producto producto = clienteRest.getForObject("http://servicio-productos/producto/ver/{id}", Producto.class, pathVariables /*en este campo se pasan los parámetros*/); 
		return new Item(producto, cantidad);
	}

	

}
