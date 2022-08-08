package com.uce.demo3.tarea26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo3.tarea26.modelo.Ciudadano;
import com.uce.demo3.tarea26.repository.ICiudadanoJpaRepository;

@Service
public class CiudadanoJpaServiceImpl implements ICiudadanoJpaService{

	@Autowired
	private ICiudadanoJpaRepository ciudadanoJpaRepository;

	@Override
	public void insertar(Ciudadano cuidadano) {
		// TODO Auto-generated method stub
		System.out.println("Conectando a la DB...");
		this.ciudadanoJpaRepository.insertar(cuidadano);
	}

	@Override
	public Ciudadano buscar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Conectando a la DB...");
		return this.ciudadanoJpaRepository.buscar(cedula);
	}

	@Override
	public void actualizar(Ciudadano cuidadano) {
		// TODO Auto-generated method stub
		System.out.println("Conectando a la DB...");
		this.ciudadanoJpaRepository.actualizar(cuidadano);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Conectando a la DB...");
		this.ciudadanoJpaRepository.eliminar(cedula);
	}

	@Override
	public List<Ciudadano> buscarCiudadanoInnerJoin(Integer horasLaborables) {
		// TODO Auto-generated method stub
		return this.ciudadanoJpaRepository.buscarCiudadanoInnerJoin(horasLaborables);
	}

	@Override
	public List<Ciudadano> buscarCiudadanoOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.ciudadanoJpaRepository.buscarCiudadanoOuterJoinLeft();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoOuterJoinRight(String nombreEmpleo) {
		// TODO Auto-generated method stub
		return this.ciudadanoJpaRepository.buscarCiudadanoOuterJoinRight(nombreEmpleo);
	}

}
