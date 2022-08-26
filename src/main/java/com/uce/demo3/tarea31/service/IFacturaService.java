package com.uce.demo3.tarea31.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaService {

	public BigDecimal crearFactura(String cedulaCliente, String numeroFactura, List<String> codigos);

}
