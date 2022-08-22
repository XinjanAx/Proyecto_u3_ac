package com.uce.demo3.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.demo3.tarea31.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFRepositoryImpl implements IDetalleFRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFactura detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}
	
	
}
