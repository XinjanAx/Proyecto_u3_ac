package com.uce.demo3.tarea33;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	static Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodoHigtOrder mHigtOrder = new ConsumoMetodoHigtOrder();
		
		System.out.println("\nSupplier\n");
		
		//Lambdas
		IAutoSupplier<String> supplier = () -> "Ford Mustang";
		Log.info("Supplier Lambda: " + supplier.modelo());
		
		//Metodos High Orde
		String modelo = mHigtOrder.consumirSupplier(()->"Chevrolet Camaro");
		Log.info("HO Supplier "+modelo);
		
		
		System.out.println("\nConsumer\n");
		
		//Lambdas
		IAutoConsumer<Integer> consumer = hp -> Log.info("Consumer Lambda Potencia: " + hp + "hp");
		consumer.potencia(200);
		
		//Metodos High Orde
		mHigtOrder.consumirConsumer(valor -> Log.info("HO Consumer Potencia: " + valor + "hp"), 180);
	
		
		System.out.println("\nPredicate\n");
		
		//Lambdas
		IAutoPredicate<Double> predicate = potencia -> {
														if(potencia <=2.9) return true;
														else return false;
														};
		
		Log.info("Predicate Lambda: es "+predicate.superAuto(2.4)+" Super auto con 2.4seg de 0 - 100km/h");
		
		//Metodos High Orde
		Log.info("HO Predicate: es " +mHigtOrder.consumirPredicate(potencia ->  {
																		if(potencia <=2.9) return true;
																		else return false;
																		}, 3.0)
																		+" Super auto con 3.0seg 0 - 100km/h");
		
		System.out.println("\nFunction\n");
		
		//Lambdas
		IAutoFunction< String, BigDecimal > function = marca -> {if(marca=="Audi") return new BigDecimal(75_000);
																else if (marca=="Nissan")return new BigDecimal(25_000);
																else return new BigDecimal(0);
																};
		String mes1 = "Nissan";
		Log.info("Function Lambda $" + function.funcion(mes1) + " por su " + mes1);
		
		//Metodos High Orde
		String mes2 = "Mazda";
		Log.info("HO Function: $"+mHigtOrder.consumirFunction(marca -> {
																		if(marca=="Mazda") return new BigDecimal(30_000);
																		else if (marca=="Chevrolet")return new BigDecimal(19_000);
																		else return new BigDecimal(0);
																		},mes2) 
																		+ " por su " + mes2 );
		
		System.out.println("\nUnary Operator\n");
		
		//Lambdas
		IAutoUnaryOperator<BigDecimal> unaryOperator = costo -> costo.add(costo.multiply(new BigDecimal(20).divide(new BigDecimal(100))));
		Log.info("Unari Operator Lambda: Costo +IVA es: $" +unaryOperator.funcion(new BigDecimal(19_000)));
		
		//Metodos High Orde
		Log.info("HO Unari Operator: Costo +IVA es: $" + mHigtOrder.consumirUnaryOperation(costo -> costo.add(costo.multiply(new BigDecimal(12).divide(new BigDecimal(100)))), new BigDecimal(34_000)));
		
	}

}
