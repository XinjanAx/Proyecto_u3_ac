package com.uce.demo3.tarea31.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t31_factura")
public class Factura {
	
	@Id
	@Column(name = "fac_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fac_seq_id")
	@SequenceGenerator(name = "fac_seq_id", sequenceName = "fac_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "fac_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fac_numero")
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "fac_id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleFactura> detalles;

	
//set get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
}
