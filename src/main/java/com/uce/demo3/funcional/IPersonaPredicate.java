package com.uce.demo3.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	public boolean evaluar(T arg1); 
}
