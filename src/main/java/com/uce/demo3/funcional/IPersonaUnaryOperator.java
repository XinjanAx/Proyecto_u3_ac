package com.uce.demo3.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
	T apply(T arg1);
}
