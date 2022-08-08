package com.uce.demo3;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.demo3.tarea26.service.ICiudadanoJpaService;


@SpringBootApplication
public class ProyectoU3AcApplication implements CommandLineRunner{
	
	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private ICiudadanoJpaService ciudadanoJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Log.info("\nINNER Join");
		Log.info(this.ciudadanoJpaService.buscarCiudadanoInnerJoin(2));
		Log.info("\nOuter Join LEFT");
		Log.info(this.ciudadanoJpaService.buscarCiudadanoOuterJoinLeft());
		Log.info("\nOuter Join RIGHT");
		Log.info(this.ciudadanoJpaService.buscarCiudadanoOuterJoinRight("Secretaria"));
	}
}
