package com.uce.demo3;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.demo3.grupal.repository.modelo.Factura;
import com.uce.demo3.grupal.service.IFacturaService;
import com.uce.demo3.mandatory.service.ITransferenciaService;


@SpringBootApplication
public class ProyectoU3AcApplication implements CommandLineRunner{
	
	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private ITransferenciaService iTransferenciaService;
	@Autowired
	private IFacturaService iFacturaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Log.info("\nTransferencia");
		//this.iTransferenciaService.realizarTransferencia("2776814596", "2145988986", new BigDecimal(1442.5));
		

		Log.info("\nFacturas\n" + this.iFacturaService.buscarFacturaInnerJoin());

	}
}
