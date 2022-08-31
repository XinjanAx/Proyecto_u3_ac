package com.uce.demo3.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCcajeroParalelo extends Thread{
	
	private CajeroParalelo cajeroP;
	
	public PCcajeroParalelo (CajeroParalelo cajero) {
		this.cajeroP = cajero;
	}
	
	//dispara el metodo a paralelizar
	public void run() { 
		this.procesar(this.cajeroP);
	}
	
	public void procesar(CajeroParalelo c) {
		long to = System.currentTimeMillis();
		System.out.println("Hilo2 Pc "+Thread.currentThread().getName());
		System.out.println("Procesando..."+c);
		for (String cliente : c.getClientes()) {
			this.atenderCliente(cliente);
		}
		System.out.println("El "+c+" concluyo el proceso");
		long tf = System.currentTimeMillis();
		long dt = (tf-to)/1000;
		System.out.println("Tiempo: " + dt+"seg");
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
