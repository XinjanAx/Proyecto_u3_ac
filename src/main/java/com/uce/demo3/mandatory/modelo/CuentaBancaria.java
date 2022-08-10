package com.uce.demo3.mandatory.modelo;

import java.math.BigDecimal;
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
@Table(name="cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@Column(name = "cb_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cb_seq_id")
	@SequenceGenerator(name = "cb_seq_id", sequenceName = "cb_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "cb_numero")
	private String numero;
	
	@Column(name = "cb_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cb_tipo")
	private String tipo;
	
	@OneToMany(mappedBy = "cuentaOrigen")
	private List<Transferencia> tranferenciasOrigen;
	
	@OneToMany(mappedBy = "cuentaDestino")
	private List<Transferencia> tranferenciasDestino;

	@Override
	public String toString() {
		return "\nCuenta Bancaria: " + numero + ", saldo: $" + saldo + ", " + tipo;
	}

//get set	
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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Transferencia> getTranferenciasOrigen() {
		return tranferenciasOrigen;
	}

	public void setTranferenciasOrigen(List<Transferencia> tranferenciasOrigen) {
		this.tranferenciasOrigen = tranferenciasOrigen;
	}

	public List<Transferencia> getTranferenciasDestino() {
		return tranferenciasDestino;
	}

	public void setTranferenciasDestino(List<Transferencia> tranferenciasDestino) {
		this.tranferenciasDestino = tranferenciasDestino;
	}

	
}
