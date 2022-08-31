package com.uce.demo3.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainSteamParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long to = System.currentTimeMillis();
		
		List<Integer> listaNumA = new ArrayList<>();
		
		for(int i=1;i<5_000;i++) {
			listaNumA.add(i);
		}
		List<String> listaTexto = listaNumA.parallelStream().map(numero -> canverIdAlumno(numero)).collect(Collectors.toList());
		System.out.println(listaTexto);
		
		long tf = System.currentTimeMillis();
		long dt = (tf-to)/1000;
		System.out.println("Tiempo: " + dt+"seg");
	}
	
	private static String canverIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "\nId: " +id.toString();
	}

}
