package com.formacionbdi.springboot.appitem.models.service;

import java.util.List;

import com.formacionbdi.springboot.appitem.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

}
