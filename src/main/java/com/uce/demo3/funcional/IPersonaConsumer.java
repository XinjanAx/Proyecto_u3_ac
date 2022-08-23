package com.uce.demo3.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {
	
	public void accept(T arg1);
}
