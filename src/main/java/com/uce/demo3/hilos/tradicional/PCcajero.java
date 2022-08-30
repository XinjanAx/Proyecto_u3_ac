package com.uce.demo3.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCcajero {
	
	public void procesar(Cajero c) {
		System.out.println("Procesando..."+c);
		for (String cliente : c.getClientes()) {
			this.atenderCliente(cliente);
		}	
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a:"+ cliente);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
