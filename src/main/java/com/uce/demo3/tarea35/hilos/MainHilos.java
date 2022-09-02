package com.uce.demo3.tarea35.hilos;

import java.util.Arrays;

public class MainHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long to = System.currentTimeMillis();
		System.out.println("Hilo "+Thread.currentThread().getName());
		
		Estudiante e1 = new Estudiante("Carlos",Arrays.asList("Matematicas","Geometria","Fisica"));
		Estudiante e2 = new Estudiante("Juan",Arrays.asList("Musica","Historia","Linguistica"));
		Estudiante e3 = new Estudiante("Maria",Arrays.asList("Matematicas Aplicadas","Teoria Molecular","Astro-Fisica"));
		Estudiante e4 = new Estudiante("Carlos",Arrays.asList("Matematicas","Geometria","Fisica"));
		Estudiante e5 = new Estudiante("Juan",Arrays.asList("Musica","Historia","Linguistica"));
		
		
		Matricula m1 = new Matricula(e1);
		m1.start();
		
		Matricula m2 = new Matricula(e2);
		m2.start();
		
		Matricula m3 = new Matricula(e3);
		m3.start();;
		
		Matricula m4 = new Matricula(e4);
		m4.start();
		
		Matricula m5 = new Matricula(e5);
		m5.start();
		
		long tf = System.currentTimeMillis();
		long dt = (tf-to)/1000;
		System.out.println("Tiempo: " + dt+"seg");
		
	}

}
