package com.uce.demo3.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo3.tarea31.repository.IClienteRepository;
import com.uce.demo3.tarea31.repository.IDetalleFRepository;
import com.uce.demo3.tarea31.repository.IFacturaERepository;
import com.uce.demo3.tarea31.repository.IFacturaRepository;
import com.uce.demo3.tarea31.repository.IProductoRepository;
import com.uce.demo3.tarea31.repository.modelo.Cliente;
import com.uce.demo3.tarea31.repository.modelo.DetalleFactura;
import com.uce.demo3.tarea31.repository.modelo.Factura;
import com.uce.demo3.tarea31.repository.modelo.FacturaElectronica;
import com.uce.demo3.tarea31.repository.modelo.Producto;

@Service
public class GestorServiceImpl implements IGestorService{
	
	@Autowired
	private IFElectronicaService electronicaService;
	
	@Autowired
	private IFacturaService facturaService;
	
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigos) {
		 
		BigDecimal monto = this.facturaService.crearFactura(cedulaCliente, numeroFactura, codigos);
		
	    this.electronicaService.crearFacturaElectronica(numeroFactura, monto, codigos.size());
	      
	}
}
