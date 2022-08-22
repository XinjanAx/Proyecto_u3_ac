package com.uce.demo3.tarea31.repository;

import com.uce.demo3.tarea31.repository.modelo.Producto;

public interface IProductoRepository {
	
	public Producto buscarProducto (String codigoBarras); 
	public void actualizarProducto (Producto producto);
	
}
