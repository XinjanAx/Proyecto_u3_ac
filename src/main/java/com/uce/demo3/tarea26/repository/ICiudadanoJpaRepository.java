package com.uce.demo3.tarea26.repository;

import java.util.List;
import com.uce.demo3.tarea26.modelo.Ciudadano;

public interface ICiudadanoJpaRepository {
	
	public void insertar (Ciudadano cuidadano);
    public Ciudadano buscar (String cedula);
    public void actualizar (Ciudadano cuidadano);
    public void eliminar (String cedula);
    
    public List<Ciudadano> buscarCiudadanoInnerJoin(Integer horasLaborables);
    public List<Ciudadano> buscarCiudadanoOuterJoinLeft();
    public List<Ciudadano> buscarCiudadanoOuterJoinRight(String nombreEmpleo);
    
}
