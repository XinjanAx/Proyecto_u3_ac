package com.uce.demo3.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
		
		//	PREDICATE
		System.out.println("\nPREDICATE");
		//Clases
		//Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");		
		Log.info("Predicate Lambda "+predicateLambda.evaluar("Zinldjan"));
		
		//Metodos High Order
		
		
		//	FUNCTION
		System.out.println("\nFUNCTION");
		//Clases
		//Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> Integer.parseInt(cadena)-2;	
		Log.info("FUNCTION Lambda "+functionLambda.aplicar("7"));
		
		//Metodos High Order
		String vHO = metodosHO.consumirFunction(valor3 ->"valor",1);
		Log.info("HO FUNCTION: "+  vHO);
		
		
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
