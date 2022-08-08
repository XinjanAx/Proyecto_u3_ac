package com.uce.demo3.tarea26.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empleo")
public class Empleo {
	
	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seq_id")
	@SequenceGenerator(name = "job_seq_id", sequenceName = "job_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "job_nombre")
	private String nombre;
	
	@Column(name = "job_fecha_contratacion")
	private LocalDate fechaC;
	
	@Column(name = "job_horas")
	private Integer horas;
	
	@Column(name = "job_salario")
	private BigDecimal salario;
	
	@ManyToOne //no hace falta el atributo la anotacion 
	@JoinColumn(name = "job_id_ciudadano_fk")
	private Ciudadano ciudadano;

	@Override
	public String toString() {
		return "\n	Empleo " + id + ": " + nombre + ", fecha " + fechaC + ", horas " + horas + ", $"
				+ salario;
	}
	
//get set 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaC() {
		return fechaC;
	}

	public void setFechaC(LocalDate fechaC) {
		this.fechaC = fechaC;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
}
