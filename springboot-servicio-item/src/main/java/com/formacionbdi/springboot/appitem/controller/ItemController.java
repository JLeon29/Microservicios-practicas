package com.formacionbdi.springboot.appitem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.appitem.models.Item;
import com.formacionbdi.springboot.appitem.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	
	@GetMapping("/listar")
	public List<Item> listar(){
		
		return itemService.findAll();
		
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		
		return itemService.findById(id, cantidad);
	}

}
