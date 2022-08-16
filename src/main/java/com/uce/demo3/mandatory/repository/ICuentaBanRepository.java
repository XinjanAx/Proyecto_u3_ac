package com.uce.demo3.mandatory.repository;

import com.uce.demo3.mandatory.modelo.CuentaBancaria;

public interface ICuentaBanRepository {

	public void actualizar (CuentaBancaria cuentaB);
	public CuentaBancaria buscarPorNumero (String numCuenta);
	public void insertar(CuentaBancaria c);
}
