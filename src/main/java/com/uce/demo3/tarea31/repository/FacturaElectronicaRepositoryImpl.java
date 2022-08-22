package com.uce.demo3.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.demo3.tarea31.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaERepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(FacturaElectronica factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}
}
