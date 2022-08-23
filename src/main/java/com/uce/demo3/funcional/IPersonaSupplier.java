package com.uce.demo3.funcional;

@FunctionalInterface
public interface IPersonaSupplier<T> {
	public T getNombre();
}
