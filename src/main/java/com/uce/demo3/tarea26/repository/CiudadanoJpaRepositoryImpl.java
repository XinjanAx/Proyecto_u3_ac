package com.uce.demo3.tarea26.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.demo3.join.modelo.Hotel;
import com.uce.demo3.tarea26.modelo.Ciudadano;


@Repository
@Transactional
public class CiudadanoJpaRepositoryImpl implements ICiudadanoJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ciudadano cuidadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuidadano);
	}

	@Override
	public Ciudadano buscar(String cedula) {
		// TODO Auto-generated method stub
		Query myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.cedula = :datoCedula");
		myTypedQuery.setParameter("datoCedula", cedula);
		return (Ciudadano) myTypedQuery.getSingleResult();
	}

	@Override
	public void actualizar(Ciudadano cuidadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuidadano);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Ciudadano c = this.buscar(cedula);
		this.entityManager.refresh(c);
		}

	@Override
	public List<Ciudadano> buscarCiudadanoInnerJoin(Integer horasLaborables) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c JOIN c.empleo e WHERE e.horas = :datoHorasL", Ciudadano.class);
		myQuery.setParameter("datoHorasL", horasLaborables);
		return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c LEFT JOIN c.empleo e",Ciudadano.class); 
        return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoOuterJoinRight(String nombreEmpleo) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c RIGHT JOIN c.empleo e WHERE e.nombre = :datoNombreE",Ciudadano.class); 
		myQuery.setParameter("datoNombreE", nombreEmpleo);
		return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoJoinWhere(BigDecimal salario) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c, Empleo e WHERE c = e.ciudadano and e.salario = :datoSalario ",Ciudadano.class);
        myQuery.setParameter("datoSalario", salario);
        return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoJoinFtch(Integer horasLaborables) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c JOIN FETCH c.empleo e WHERE  e.horas = :datoHorasL ",Ciudadano.class);
        myQuery.setParameter("datoHorasL", horasLaborables);
        return myQuery.getResultList();
	}
}
