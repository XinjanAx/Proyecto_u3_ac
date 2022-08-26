package com.uce.demo3.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.demo3.tarea31.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarProducto(String codigoBarras) {
		TypedQuery<Producto> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p  WHERE p.codigoBarras = :datoBarras", Producto.class)
				.setParameter("datoBarras", codigoBarras);
		return myTypedQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}
}
