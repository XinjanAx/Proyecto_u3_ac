package com.uce.demo3.tarea31.service;

import java.math.BigDecimal;

public interface IFElectronicaService {
	
	public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items);

}
