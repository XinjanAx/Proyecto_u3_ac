package com.uce.demo3.mandatory.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo3.mandatory.modelo.CuentaBancaria;
import com.uce.demo3.mandatory.modelo.Transferencia;
import com.uce.demo3.mandatory.repository.ICuentaBanRepository;
import com.uce.demo3.mandatory.repository.ITransferenciaRepository;

@Service
public class TranferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ICuentaBanRepository ctaBanRepository;
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		CuentaBancaria ctaO = this.ctaBanRepository.buscarPorNumero(ctaOrigen);
			BigDecimal saldo1 = ctaO.getSaldo();
			BigDecimal saldo2 = saldo1.subtract(monto);
			ctaO.setSaldo(saldo2);
		
		this.ctaBanRepository.actualizar(ctaO);	
		
		CuentaBancaria ctaD = this.ctaBanRepository.buscarPorNumero(ctaDestino);
			BigDecimal saldo3 = ctaD.getSaldo();
			BigDecimal saldo4 = saldo3.add(monto);
			ctaD.setSaldo(saldo4);
		
		
		this.ctaBanRepository.actualizar(ctaD);

		Transferencia t1 = new Transferencia();
			t1.setFecha(LocalDateTime.now());
			t1.setCuentaOrigen(ctaO);
			t1.setCuentaDestino(ctaD);
			t1.setMonto(monto);
		this.transferenciaRepository.crearTranferencia(t1);
	
		if(monto.compareTo(saldo1) > 0) { 
            throw new RuntimeException(); //ejecuta rollback
        }	
	}
	

}
