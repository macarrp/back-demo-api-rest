package com.marcebits.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductoDto {

	Long idProducto;

	String nombre;

	CategoriaProductoDto categoria;

	String descripcion;

	BigDecimal precioUnidad;

	int unidadesEnAlmacen;

	String imagenUrl;

	boolean activo;
	
	LocalDate fechaCreada;

	LocalDate fechaModificacion;
}
