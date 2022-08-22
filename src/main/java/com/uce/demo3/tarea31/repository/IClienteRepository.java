package com.uce.demo3.tarea31.repository;

import com.uce.demo3.tarea31.repository.modelo.Cliente;

public interface IClienteRepository {
	
	public Cliente buscarCliente (String cedula);
	
}