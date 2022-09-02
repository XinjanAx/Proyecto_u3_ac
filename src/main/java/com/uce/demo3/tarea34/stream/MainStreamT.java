package com.uce.demo3.tarea34.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainStreamT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
//		SUPPLIER
			System.out.println("SUPPLIER");
			//JAVA
			Stream <String> test = Stream.generate(()-> "* * * * *").limit(4);
			test.forEach(cadena -> System.out.println(cadena));
			
			
//		CONSUMER
			System.out.println("\nCONSUMER");			
			List<Integer> listaNum = Arrays.asList(1,2,3,4,5);
			listaNum.forEach(numero -> System.out.println(numero+1+"=1+"+numero));
			
			
//		PREDICATE
			System.out.println("\nPREDICATE");
			List<String> listaPre = Arrays.asList("oso","burro","cacahuate","arboleda","pullfiction");
			Stream<String> nuevaLista = listaPre.stream().filter(caracter -> caracter.contains("u"));
			nuevaLista.forEach(dato->System.out.println(dato));
			
			
//		FUNCTION
			System.out.println("\nFUNCTION");
			
			Stream<Boolean>listaFunc= listaPre.stream().map(palabra -> palabra.contains("u"));
			listaFunc.forEach(v -> System.out.println(v));
	}

}
