package com.uce.demo3.tarea31.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.demo3.tarea31.repository.modelo.Producto;

public interface IGestorService {
	
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigos);
	public void actualizarStock(Producto p, Integer cantidad);
	public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items );
	  
}
