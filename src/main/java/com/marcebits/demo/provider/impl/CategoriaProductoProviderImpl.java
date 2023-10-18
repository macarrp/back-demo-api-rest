package com.marcebits.demo.provider.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcebits.demo.entity.CategoriaProductoEntity;
import com.marcebits.demo.provider.CategoriaProductoProvider;
import com.marcebits.demo.repository.CategoriaProductoRepository;

@Component
public class CategoriaProductoProviderImpl implements CategoriaProductoProvider {

	@Autowired
	private CategoriaProductoRepository productoCategoriaRepository;
	
	@Override
	public List<CategoriaProductoEntity> getAll() {
		return productoCategoriaRepository.findAll();
	}

	@Override
	public CategoriaProductoEntity getById(Long id) {
		Optional<CategoriaProductoEntity> productoEntityOpt = productoCategoriaRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return null;
		}
		
		return productoEntityOpt.get();
	}

	@Override
	public Long add(CategoriaProductoEntity newObject) {
		CategoriaProductoEntity savedEntity = productoCategoriaRepository.save(newObject);
		return savedEntity.getIdCategoria();
	}

	@Override
	public String update(CategoriaProductoEntity newObject) {
		Optional<CategoriaProductoEntity> productoEntityOpt = productoCategoriaRepository.findById(newObject.getIdCategoria());
		
		if(productoEntityOpt.isEmpty()) {
			return null;
		}
		
		productoCategoriaRepository.save(newObject);
		return "Producto guardado con éxito";
	}

	@Override
	public String delete(Long id) {
		Optional<CategoriaProductoEntity> productoEntityOpt = productoCategoriaRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return null;
		}
		
		productoCategoriaRepository.deleteById(id);
		return "Producto eliminado con éxito";
	}

}
