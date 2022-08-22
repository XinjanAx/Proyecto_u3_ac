package com.uce.demo3.grupal.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.demo3.grupal.repository.modelo.FacturaG;

@Repository
@Transactional
public class FacturaGRepositoryImpl implements IFacturaGRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(FacturaG factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(FacturaG factura) {
		this.entityManager.merge(factura);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		Query query = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :dato_fecha");
		query.setParameter("dato_fecha", fecha);
		return query.executeUpdate();
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.entityManager.find(FacturaG.class, id));
	}

	@Override
	public FacturaG buscar(Integer id) {
		return this.entityManager.find(FacturaG.class, id);
	}

	@Override
	public FacturaG buscarPorNumero(String numero) {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero > :numero",
				FacturaG.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public List<FacturaG> buscarFacturaInnerJoin(BigDecimal subtotal) {
		TypedQuery<FacturaG> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal > :subtotal", FacturaG.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaG> buscarFacturaInnerJoinDemanda(BigDecimal subtotal) {
		TypedQuery<FacturaG> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal > :subtotal", FacturaG.class);
		myQuery.setParameter("subtotal", subtotal);

		List<FacturaG> lista = myQuery.getResultList();

		lista.stream().forEach(f -> f.getDetalles().size());

		return lista;
	}

	@Override
	public List<FacturaG> buscarFacturaInnerJoin() {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles",
				FacturaG.class);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaG> buscarFacturaOuterLeftJoin(BigDecimal subtotal) {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.subtotal > :subtotal", FacturaG.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaG> buscarFacturaOuterLeftJoin() {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles",
				FacturaG.class);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaG> buscarFacturaOuterRightJoin(BigDecimal subtotal) {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.subtotal > :subtotal", FacturaG.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaG> buscarFacturaWhereJoin(BigDecimal subtotal) {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, DetalleFactura df WHERE f = df.factura AND df.subtotal > :subtotal",
				FacturaG.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaG> buscarFacturaJoinFetch(BigDecimal subtotal) {
		TypedQuery<FacturaG> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.subtotal > :subtotal", FacturaG.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

}
