package com.uce.demo3.join.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="habitacion")
public class Habitacion {
	
	@Id
	@Column(name = "hab_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hab_seq_id")
	@SequenceGenerator(name = "hab_seq_id", sequenceName = "hab_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "hab_numero")
	private String numero;
	
	@Column(name = "hab_piso")
	private String piso;
	
	@Column(name = "hab_tipo")
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "hab_id_hotel_fk")
	private Hotel hotelRel;	
	
	@Override
	public String toString() {
		return "\n	Habitacion " + numero + ", " + tipo;
	}
	
//set get
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Hotel getHotelRel() {
		return hotelRel;
	}

	public void setHotelRel(Hotel hotelRel) {
		this.hotelRel = hotelRel;
	}	
	
	
}
