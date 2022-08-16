package com.uce.demo3.mandatory.service;

import java.math.BigDecimal;

import com.uce.demo3.mandatory.modelo.CuentaBancaria;

public interface ICuentaBanService {
	
	public Boolean crearCuenta(String tipo, String numero, BigDecimal monto);

	public CuentaBancaria buscar(String numero);

	public Boolean actualizar(CuentaBancaria cuentaBancaria);

}
