package com.uce.demo3.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long to = System.currentTimeMillis();
		
		System.out.println("Hilo1 "+Thread.currentThread().getName());
		CajeroParalelo c1 = new CajeroParalelo("Bena",Arrays.asList("Rumiñahui","Pablo","Saitama"));
		CajeroParalelo c2 = new CajeroParalelo("Yisus",Arrays.asList("Lasso","Pedro","Genos"));
		CajeroParalelo c3 = new CajeroParalelo("Guana",Arrays.asList("Ariana","Tairon","Fubuki"));

		PCcajeroParalelo gestorAtencion1  = new PCcajeroParalelo(c1);
		gestorAtencion1.start();
		PCcajeroParalelo gestorAtencion2  = new PCcajeroParalelo(c2);
		gestorAtencion2.start();
		PCcajeroParalelo gestorAtencion3  = new PCcajeroParalelo(c3);
		gestorAtencion3.start();
		
		long tf = System.currentTimeMillis();
		long dt = (tf-to)/1000;
		System.out.println("Tiempo: " + dt+"seg");
		
	}

}
