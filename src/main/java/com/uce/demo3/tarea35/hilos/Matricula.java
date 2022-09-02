package com.uce.demo3.tarea35.hilos;

import java.util.concurrent.TimeUnit;

public class Matricula extends Thread{
	
	private Estudiante estudiante;
	
	public void run() { 
		this.matricular(this.estudiante);
	}
	
	public Matricula(Estudiante estudiante) {
		super();
		this.estudiante = estudiante;
	}

	public void matricular(Estudiante e) {
		
		long to = System.currentTimeMillis();
		
		System.out.println("Hilo Matricula "+Thread.currentThread().getName());
		System.out.println("Matricular..."+e);
		for (String materias : e.getMaterias()) {
			this.validandoMaterias(materias);
		}
		System.out.println(e+" concluyo la matricula Exitosamente...");
		long tf = System.currentTimeMillis();
		long dt = (tf-to)/1000;
		System.out.println("Tiempo: " + dt+"seg");
	}
	
	private void validandoMaterias(String materia) {
		System.out.println("Atendiendo a:"+ materia);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
