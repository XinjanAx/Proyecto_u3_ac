package com.uce.demo3.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo3.tarea31.repository.IFacturaERepository;
import com.uce.demo3.tarea31.repository.modelo.FacturaElectronica;
@Service
public class FElectronicaServiceImpl implements IFElectronicaService{
	
	@Autowired
	private IFacturaERepository facturaERepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items) {
		// TODO Auto-generated method stub
        FacturaElectronica facturaElectronica = new FacturaElectronica();
        facturaElectronica.setFecha(LocalDateTime.now());
        facturaElectronica.setMonto(monto);
        facturaElectronica.setNItems(items);
        facturaElectronica.setNumero(numeroFact);
        
        this.facturaERepository.insertar(facturaElectronica);

        throw new RuntimeException();
	}

}
