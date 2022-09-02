package com.uce.demo3.tarea35.hilos;

import java.util.List;

public class Estudiante {
	
	private String nombre; 
	private List<String> materias;
	
	public Estudiante(String nombre, List<String> materias) {
		super();
		this.nombre = nombre;
		this.materias = materias;
	}
	
	@Override
	public String toString() {
		return "\nEstudiante " + nombre + ", materias" + materias ;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getMaterias() {
		return materias;
	}
	public void setMaterias(List<String> materias) {
		this.materias = materias;
	}
	
	

}
