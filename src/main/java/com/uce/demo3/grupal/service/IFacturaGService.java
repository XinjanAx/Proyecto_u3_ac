package com.uce.demo3.grupal.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.demo3.grupal.repository.modelo.FacturaG;

public interface IFacturaGService {

	public void insertar(FacturaG factura);

	public void actualizar(FacturaG factura);

	public void eliminar(Integer id);

	public int actualizarFecha(LocalDateTime fecha);

	public FacturaG buscar(Integer id);

	public FacturaG buscarPorNumero(String numero);

	public List<FacturaG> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<FacturaG> buscarFacturaInnerJoinDemanda(BigDecimal subtotal);

	public List<FacturaG> buscarFacturaInnerJoin();

	public List<FacturaG> buscarFacturaOuterLeftJoin(BigDecimal subtotal);

	public List<FacturaG> buscarFacturaOuterLeftJoin();

	public List<FacturaG> buscarFacturaOuterRightJoin(BigDecimal subtotal);

	public List<FacturaG> buscarFacturaWhereJoin(BigDecimal subtotal);

	public List<FacturaG> buscarFacturaJoinFetch(BigDecimal subtotal);
}
