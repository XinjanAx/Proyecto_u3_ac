package com.uce.demo3.join.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.demo3.join.modelo.Hotel;
import com.uce.demo3.join.repository.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository;
	
	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinRigth(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFtch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelJoinFtch(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		Log.info("Transaccion activa Service: "+ TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepository.buscarHotelOuterJoinLeft();
	}

}
