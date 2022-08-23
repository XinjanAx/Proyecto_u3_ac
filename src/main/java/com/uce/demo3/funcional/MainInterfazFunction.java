package com.uce.demo3.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfazFunction {
	
	static Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
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
		Log.info("Supplier Lambda 3ra Edad Clase: " + supplierLambdaTE.getNombre()+"\n");
		
		
		
		//	CONSUMER
		System.out.println("CONSUMER");
		
		//Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer Clase");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		
		//	PREDICATE
		//Clases
		
		//Lambdas
		
	}

}
