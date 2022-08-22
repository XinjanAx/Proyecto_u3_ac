package com.uce.demo3.tarea31.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t31_factura_electronica")
public class FacturaElectronica {
	
	@Id
	@Column(name = "fac_e_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fac_e_seq_id")
	@SequenceGenerator(name = "fac_e_seq_id", sequenceName = "fac_e_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "fac_e_numero")
	private String numero;
	
	@Column(name = "fac_e_fecha")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fac_e_monto")
	private BigDecimal monto;
	
	@Column(name = "fac_e_n_items")
	private Integer NItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fechaCreacion;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fechaCreacion = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNItems() {
		return NItems;
	}

	public void setNItems(Integer nItems) {
		NItems = nItems;
	}
}
