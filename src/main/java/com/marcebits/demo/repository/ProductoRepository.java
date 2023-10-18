package com.marcebits.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcebits.demo.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{

}
