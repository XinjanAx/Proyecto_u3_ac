package com.uce.demo3.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.demo3.tarea31.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarCliente(String cedula) {
		TypedQuery <Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula = :datoCedula",Cliente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	
}
