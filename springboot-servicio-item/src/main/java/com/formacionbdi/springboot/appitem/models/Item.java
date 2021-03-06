package com.formacionbdi.springboot.appitem.models;

public class Item {
	
	
	private Producto producto;
	private Integer cantidad;

	public Item() {
		super();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	//Se crea el método para el resultado total
	public Double getTotal() {
		return producto.getPrecio()*cantidad.doubleValue(); //doubleValue() para que se convierta en double
	}
	
	//TODOS LOS GET SALEN EN JSON - POSTMAN
	
}
