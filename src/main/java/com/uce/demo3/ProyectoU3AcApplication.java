package com.uce.demo3;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.demo3.tarea31.service.IGestorService;


@SpringBootApplication
public class ProyectoU3AcApplication implements CommandLineRunner{
	
	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IGestorService gestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> productos= new ArrayList<>();
		
		productos.add("6843521118");
		productos.add("8475224130");
		productos.add("3354784562");
		productos.add("6843521118");

		this.gestorService.comprar("1704456214", "0-0071-0054", productos);

	}
}
