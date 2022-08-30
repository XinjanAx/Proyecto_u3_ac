package com.uce.demo3.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfazFunction {
	
	static Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
//	SUPPLIER
		System.out.println("SUPPLIER");
		
		//Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl(); //necesito una clase Impl
		Log.info("Supplier Clase: " + supplier.getNombre());
		
		IPersonaSupplier<Integer> supplierTE = new PersonaSupplierTEImpl();
		Log.info("Supplier 3ra Edad Clase: " + supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Alex2";
		Log.info("Supplier Lambda Clase: " + supplierLambda.getNombre());
		
		IPersonaSupplier<Integer> supplierLambdaTE = () -> 3;
		Log.info("Supplier Lambda 3ra Edad Clase: " + supplierLambdaTE.getNombre());
		
		//Metodos High Orde
		String valor = metodosHO.consumirSupplier(()->"hola");
		Log.info("HO Supplier "+valor);
		
		//JAVA
		System.out.println("Java SUPPLIER");
		Stream <String> test = Stream.generate(()-> "Alex Java").limit(2);
		test.forEach(cadena -> System.out.println(cadena));
		
		
//	CONSUMER
		System.out.println("\nCONSUMER");
		
		//Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer Clase");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//Metodos High Orde
		metodosHO.consumirConsumer(valor2 -> System.out.println(valor), 2);
		
		//JAVA
		System.out.println("Java CONSUMER");
		List<Integer> listaNum = Arrays.asList(1,2,3,4,5);
		listaNum.forEach(numero -> System.out.println(numero));
		
		
		
//	PREDICATE
		System.out.println("\nPREDICATE");
		//Clases
		//Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");		
		Log.info("Predicate Lambda "+predicateLambda.evaluar("Zinldjan"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("X"), "Zinldjan");
		Log.info("HO Predicate:" + respuesta);
		
		//JAVA 
		System.out.println("Java PREDICATE");
		Stream<Integer> nuevaLista = listaNum.stream().filter(numero -> numero >= 3);
		nuevaLista.forEach(numero -> System.out.println(numero));
		
		
//	FUNCTION
		System.out.println("\nFUNCTION");
		//Clases
		//Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> Integer.parseInt(cadena)-2;	
		Log.info("FUNCTION Lambda "+functionLambda.aplicar("7"));
		
		//Metodos High Order
		String vHO = metodosHO.consumirFunction(valor3 ->"valor",1);
		Log.info("HO FUNCTION: "+  vHO);
		
		//JAVA 
		System.out.println("Java FUNCTION");
		
		Stream<String>nuevaListaF= listaNum.stream().map(numLista -> {
										Integer val = numLista +1;
										String cadena = "num " + val.toString();
										return cadena;
										});
		nuevaListaF.forEach(v -> System.out.println(v));
		
//	UNARY OPERATOR
		System.out.println("\nUNARY OPERATOR");
		//Clases
		//Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {			
			return cadena.concat("sufijo");
		};
		Log.info("UNARY OPERATOR Lambda "+unaryLambda.apply("7"));
		
		//Metodos High Order
	}

}
