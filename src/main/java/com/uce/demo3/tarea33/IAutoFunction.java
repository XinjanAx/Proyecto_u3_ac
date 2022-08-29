package com.uce.demo3.tarea33;

@FunctionalInterface
public interface IAutoFunction<T,R> {
	R funcion(T arg);
}
