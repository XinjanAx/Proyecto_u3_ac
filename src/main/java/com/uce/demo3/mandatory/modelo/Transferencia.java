package com.uce.demo3.mandatory.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name="transferencia")
public class Transferencia {
	
	@Id
	@Column(name = "trans_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trans_seq_id")
	@SequenceGenerator(name = "trans_seq_id", sequenceName = "trans_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "trans_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "trans_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "trans_cta_origen")
	private CuentaBancaria cuentaOrigen;
	
	@ManyToOne
	@JoinColumn(name = "trans_cta_destino")
	private CuentaBancaria cuentaDestino;

	@Override
	public String toString() {
		return "\nTransferencia:  fecha " + fecha + ", monto $" + monto + ", \n  Cuenta Origen" + cuentaOrigen
				+ ", \n  Cuenta Destino " + cuentaDestino;
	}
	
//get set
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

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
}
