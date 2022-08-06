package com.uce.demo3;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.demo3.join.modelo.Hotel;
import com.uce.demo3.join.service.IHotelService;

@SpringBootApplication
public class ProyectoU3AcApplication implements CommandLineRunner{
	
	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Log.info("\nRelacionamiento where");
		
		Log.info("\n	" + this.hotelService.buscarHotelJoinWhere("familiar"));
	
		Log.info("\nJOIN FETCH");
		
		Log.info("\n	" + this.hotelService.buscarHotelJoinFtch("familiar"));	
	}
}
