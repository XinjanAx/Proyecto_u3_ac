package com.uce.demo3.tarea26.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {

	@Id
	@Column(name = "ciud_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciud_seq2_id")
	@SequenceGenerator(name = "ciud_seq2_id", sequenceName = "ciud_seq2_id", allocationSize = 1)
	private Integer id;

	@Column(name = "ciud_nombre")
	private String nombre;

	@Column(name = "ciud_apellido")
	private String apellido;

	@Column(name = "ciud_cedula")
	private String cedula;

	@Column(name = "ciud_fecha")
	private LocalDate fecha;
	                       //nombre de la referencia en la clase segundaria
	@OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Empleo> empleo;

	@Override
	public String toString() {
		return "\nCiudadano " + cedula + ", " + nombre + " " + apellido + ", fecha: " + fecha + "\n		Empleos: "
				+ empleo;
	}

//get set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Empleo> getEmpleo() {
		return empleo;
	}

	public void setEmpleo(List<Empleo> empleo) {
		this.empleo = empleo;
	}
}
