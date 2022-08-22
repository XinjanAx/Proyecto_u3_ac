package com.uce.demo3.grupal.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo3.grupal.repository.IFacturaGRepository;
import com.uce.demo3.grupal.repository.modelo.FacturaG;

@Service
public class FacturaGServiceImpl implements IFacturaGService {

	@Autowired
	private IFacturaGRepository iFacturaRepository;

	@Override
	public void insertar(FacturaG factura) {
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	public void actualizar(FacturaG factura) {
		this.iFacturaRepository.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		return this.iFacturaRepository.actualizarFecha(fecha);
	}

	@Override
	public FacturaG buscar(Integer id) {
		return this.iFacturaRepository.buscar(id);
	}

	@Override
	public FacturaG buscarPorNumero(String numero) {
		return this.iFacturaRepository.buscarPorNumero(numero);
	}

	@Override
	public List<FacturaG> buscarFacturaInnerJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaInnerJoin(subtotal);
	}

	@Override
	public List<FacturaG> buscarFacturaInnerJoinDemanda(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoinDemanda(subtotal);
	}

	@Override
	public List<FacturaG> buscarFacturaInnerJoin() {
		return this.iFacturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<FacturaG> buscarFacturaOuterLeftJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin(subtotal);
	}

	@Override
	public List<FacturaG> buscarFacturaOuterLeftJoin() {
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<FacturaG> buscarFacturaOuterRightJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaOuterRightJoin(subtotal);
	}

	@Override
	public List<FacturaG> buscarFacturaWhereJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaWhereJoin(subtotal);
	}

	@Override
	public List<FacturaG> buscarFacturaJoinFetch(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinFetch(subtotal);
	}

}