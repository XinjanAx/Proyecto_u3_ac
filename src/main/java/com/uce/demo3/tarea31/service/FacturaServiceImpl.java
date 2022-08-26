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
import com.uce.demo3.tarea31.repository.IFacturaRepository;
import com.uce.demo3.tarea31.repository.IProductoRepository;
import com.uce.demo3.tarea31.repository.modelo.Cliente;
import com.uce.demo3.tarea31.repository.modelo.DetalleFactura;
import com.uce.demo3.tarea31.repository.modelo.Factura;
import com.uce.demo3.tarea31.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	

	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal crearFactura(String cedulaCliente, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		Cliente c1 = this.clienteRepository.buscarCliente(cedulaCliente);
        
	 	Factura f1 = new Factura();
        f1.setCliente(c1);
        f1.setNumero(numeroFactura);
        f1.setFecha(LocalDateTime.now());
        this.facturaRepository.insertar(f1);

        
	    BigDecimal subtotal;
	    BigDecimal monto  = new BigDecimal(0);
	    Integer items = 0;
	    List<DetalleFactura> detalles = new ArrayList<>();
	    Integer stock;
	    
	    for (String cod : codigos) {
	        	
	        	Producto p = this.productoRepository.buscarProducto(cod);
	      
	            DetalleFactura df = new DetalleFactura();
	            	df.setCantidad(1);
	            	df.setFactura(f1);
	            	df.setProducto(p);
	            	subtotal = p.getPrecio();
	            	df.setSubTotal(subtotal);
	            detalles.add(df);
	            monto = monto.add(subtotal);
	            items++;
	           
	            stock = p.getStock() - 1;
		        if(stock >= 0){
		        	this.productoRepository.actualizarProducto(p);
		        }
		        else {
		        	throw new RuntimeException();
		        }
	        }
	    	f1.setDetalles(detalles);
	        this.facturaRepository.insertar(f1);
			return monto;
	}

}
