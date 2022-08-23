package com.uce.demo3.funcional;

@FunctionalInterface
public interface IPersonaFunction<R,T> {
	R aplicar (T arg1);
}
