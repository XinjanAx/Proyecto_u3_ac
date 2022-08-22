package com.uce.demo3.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IDetalleFRepository detalleFRepository;
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IFacturaERepository facturaERepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	
	
	@Override
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigos) {
		 
		Cliente c1 = this.clienteRepository.buscarCliente(cedulaCliente);
	        
		 	Factura f1 = new Factura();
	        f1.setCliente(c1);
	        f1.setNumero(numeroFactura);
	        f1.setFecha(LocalDateTime.now());
	        this.facturaRepository.insertar(f1);

	        
	    BigDecimal subtotal;
        BigDecimal monto  = new BigDecimal(0);
        Integer items = 0;
        
	    for (String cod : codigos) {
	        	
	        	Producto p = this.productoRepository.buscarProducto(cod);
	      
	            DetalleFactura df = new DetalleFactura();
	            	df.setCantidad(1);
	            	df.setFactura(f1);
	            	df.setProducto(p);
	            	subtotal = p.getPrecio().multiply(new BigDecimal(df.getCantidad()));
	            	df.setSubTotal(subtotal);
	            this.detalleFRepository.insertar(df);
	            
	            monto = monto.add(subtotal);
	            items = items + df.getCantidad();
	           
	            this.actualizarStock(p, df.getCantidad());
	        }

	        this.facturaRepository.insertar(f1);
	        
	        this.crearFacturaElectronica(numeroFactura, monto, items);
	      
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarStock(Producto p, Integer cantidad) {
			Integer stock  = p.getStock() - cantidad;
	        if(stock <= 0){
	        this.productoRepository.actualizarProducto(p);
	        }
	        else {
	        	throw new RuntimeException();
	        }
	    }

	@Override
	public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items) {
        FacturaElectronica facturaElectronica = new FacturaElectronica();
        facturaElectronica.setFecha(LocalDateTime.now());
        facturaElectronica.setMonto(monto);
        facturaElectronica.setNItems(items);
        facturaElectronica.setNumero(numeroFact);
        
        this.facturaERepository.insertar(facturaElectronica);

        // throw new RuntimeException();
	}
}
