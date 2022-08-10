package com.uce.demo3.mandatory.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.demo3.mandatory.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBanRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaB) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaB);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numCuenta) {
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :numeroCta", CuentaBancaria.class);
        myQuery.setParameter("numeroCta", numCuenta);
        return myQuery.getSingleResult();
	}

}
