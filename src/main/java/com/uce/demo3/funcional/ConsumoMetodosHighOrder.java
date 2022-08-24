package com.uce.demo3.funcional;

public class ConsumoMetodosHighOrder {
	
	public String consumirSupplier(IPersonaSupplier<String> funcion) {
        return funcion.getNombre() + " Se proceso el dato";
    }

    public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
        funcion.accept(valor);
    }

    public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
        return funcion.evaluar(valor);
    }

    public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
        return funcion.aplicar(valor);
    }
}
