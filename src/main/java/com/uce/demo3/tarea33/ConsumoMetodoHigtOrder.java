package com.uce.demo3.tarea33;

import java.math.BigDecimal;

public class ConsumoMetodoHigtOrder {
	
	public String consumirSupplier(IAutoSupplier<String> supp) {
        return supp.modelo()+ " HO";
    }
	
    public void consumirConsumer(IAutoConsumer<Integer> funcion, Integer valor) {
        funcion.potencia(valor);
    }
    
    public boolean consumirPredicate(IAutoPredicate<Double> funcion, Double valor) {
        return funcion.superAuto(valor);
    }
    
    public BigDecimal consumirFunction(IAutoFunction<String, BigDecimal> funcion, String valor) {
        return funcion.funcion(valor);
    }
    
    public BigDecimal consumirUnaryOperation(IAutoUnaryOperator<BigDecimal> funcion, BigDecimal valor) {
        return funcion.funcion(valor);
    }
    
}
