package com.uce.demo3.join.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.demo3.join.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitacion ha WHERE ha.tipo = :datoTipoH", Hotel.class);
		myQuery.setParameter("datoTipoH", tipoHabitacion);
		
		//crea la demanda para el LAZY
		for(Hotel h : myQuery.getResultList()) {
			h.getHabitaciones().size();
		}
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitacion ha", Hotel.class);
		return myQuery.getResultList();
	}



	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN habitacion ha WHERE ha.tipo = :datoTipoHabitacion",Hotel.class); 
        myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
        return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN habitacion ha",Hotel.class); 
        return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion) {
	    TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGTH JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion",Hotel.class);
	    myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
	    return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel and ha.tipo =: datoTipoHabitacion ",Hotel.class);
        myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
        return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinFtch(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion",Hotel.class);
	    myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
	    return myQuery.getResultList();
	}
}
