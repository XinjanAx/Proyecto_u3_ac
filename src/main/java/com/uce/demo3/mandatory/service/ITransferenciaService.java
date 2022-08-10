package com.uce.demo3.mandatory.service;

import java.math.BigDecimal;

public interface ITransferenciaService {
	
	public void realizarTransferencia(String ctaOrigen,String ctaDestino, BigDecimal monto);
	
}
