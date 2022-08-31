package com.uce.demo3.hilos.paralelo;

import java.util.List;

public class CajeroParalelo {
	
	private String nomre;
	private List<String> clientes;
	
	public CajeroParalelo(String nomre, List<String> clientes) {
		super();
		this.nomre = nomre;
		this.clientes = clientes;
	}
	
	
	@Override
	public String toString() {
		return "Cajero " + nomre + ", clientes: " + clientes;
	}

	public String getNomre() {
		return nomre;
	}
	public void setNomre(String nomre) {
		this.nomre = nomre;
	}
	public List<String> getClientes() {
		return clientes;
	}
	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}
}
