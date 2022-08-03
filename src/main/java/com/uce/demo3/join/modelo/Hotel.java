package com.uce.demo3.join.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
	
	@Id
	@Column(name = "hot_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hot_seq_id")
	@SequenceGenerator(name = "hot_seq_id", sequenceName = "hot_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "hot_nombre")
	private String nombre;
	
	@Column(name = "hot_direccion")
	private String direccion;

	@OneToMany(mappedBy="hotelRel")
	private List<Habitacion> habitaciones;
	
	@Override
	public String toString() {
		return "\nHotel " + nombre + ", direccion: " + direccion;
	}
	
// set get 
	
	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
}
