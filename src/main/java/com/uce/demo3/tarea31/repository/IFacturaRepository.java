package com.uce.demo3.tarea31.repository;

import com.uce.demo3.tarea31.repository.modelo.Factura;

public interface IFacturaRepository {

	public void insertar(Factura factura);
	public Factura buscarNumero(String numero) ;
}
