package com.uce.demo3.tarea31.service;

import java.util.List;


public interface IGestorService {
	
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigos);
	  
}
