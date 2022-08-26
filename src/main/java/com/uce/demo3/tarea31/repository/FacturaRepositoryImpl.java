package com.uce.demo3.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.demo3.tarea31.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura buscarNumero(String numero) {
		TypedQuery<Factura> myTypedQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f  WHERE f.numero = :datoNumero  ", Factura.class)
				.setParameter("datoNumero", numero);
		return myTypedQuery.getSingleResult();
	}


	
}
