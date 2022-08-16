package com.uce.demo3.mandatory.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo3.mandatory.modelo.CuentaBancaria;
import com.uce.demo3.mandatory.repository.ICuentaBanRepository;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBanService{

	@Autowired
	private ICuentaBanRepository cuentaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Boolean crearCuenta(String tipo, String numero, BigDecimal monto) {
		try {
			
			CuentaBancaria cuenta = new CuentaBancaria();
			cuenta.setNumero(numero);
			cuenta.setTipo(tipo);
			this.cuentaRepo.insertar(cuenta);

			CuentaBancaria cuentaDepositar = cuenta;
			cuentaDepositar.setSaldo(monto);
			this.cuentaRepo.actualizar(cuentaDepositar);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CuentaBancaria buscar(String numero) {
		return this.cuentaRepo.buscarPorNumero(numero);
	}

	@Override
	public Boolean actualizar(CuentaBancaria cuentaBancaria) {
		try {
			this.cuentaRepo.actualizar(cuentaBancaria);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
