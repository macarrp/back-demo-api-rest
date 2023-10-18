package com.marcebits.demo.provider.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcebits.demo.entity.ProductoEntity;
import com.marcebits.demo.provider.ProductoProvider;
import com.marcebits.demo.repository.ProductoRepository;

@Component
public class ProductoProviderImpl implements ProductoProvider {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoEntity> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public ProductoEntity getById(Long id) {
		Optional<ProductoEntity> productoEntityOpt = productoRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return null;
		}
		
		return productoEntityOpt.get();
	}

	@Override
	public Long add(ProductoEntity newObject) {
		ProductoEntity savedEntity = productoRepository.save(newObject);
		return savedEntity.getIdProducto();
	}

	@Override
	public String update(ProductoEntity newObject) {
		Optional<ProductoEntity> productoEntityOpt = productoRepository.findById(newObject.getIdProducto());
		
		if(productoEntityOpt.isEmpty()) {
			return null;
		}
		
		productoRepository.save(newObject);
		return "Producto guardado con éxito";
	}

	@Override
	public String delete(Long id) {
		Optional<ProductoEntity> productoEntityOpt = productoRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return null;
		}
		
		productoRepository.deleteById(id);
		return "Producto eliminado con éxito";
	}

}
