package com.marcebits.demo.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTO")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Long idProducto;    

    @Column(name = "NOMBRE")
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false, insertable = false)
    private CategoriaProductoEntity categoria;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO_UNIDAD")
    private BigDecimal precioUnidad;

    @Column(name = "UDS_ALMACEN")
    private int unidadesEnAlmacen;

    @Column(name = "IMAGEN_URL")
    private String imagenUrl;

    @Column(name = "ACTIVO")
    private boolean activo;
    
    @Column(name = "FECHA_CREADA")
    @CreationTimestamp
    private String fechaCreada;

    @Column(name = "FECHA_MODIFICACION")
    @UpdateTimestamp
    private String fechaModificacion;

//    @Column(name = "FECHA_CREADA")
//    @CreationTimestamp
//    private LocalDate fechaCreada;
//
//    @Column(name = "FECHA_MODIFICACION")
//    @UpdateTimestamp
//    private LocalDate fechaModificacion;
}
