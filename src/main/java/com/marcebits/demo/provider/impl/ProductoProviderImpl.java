package com.marcebits.demo.provider.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcebits.demo.dto.ProductoDto;
import com.marcebits.demo.entity.ProductoEntity;
import com.marcebits.demo.provider.ProductoProvider;
import com.marcebits.demo.repository.ProductoRepository;
import com.marcebits.demo.utils.ResponseDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductoProviderImpl implements ProductoProvider {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public ResponseDto<List<ProductoDto>> getAll() {
		List<ProductoEntity> productosEntity = productoRepository.findAll();
		
		List<ProductoDto> productosDto = new ArrayList<>();
		
		productosEntity.forEach(prod -> {
			productosDto.add(
					modelMapper.map(prod, ProductoDto.class)
			);			
		});
		;
		
		return ResponseDto.success(productosDto);
	}

	@Override
	public ResponseDto<ProductoDto> getById(Long id) {		
		Optional<ProductoEntity> productoEntityOpt = productoRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return ResponseDto.fail("El producto no existe");
		}
		
		ProductoDto productoDto = modelMapper.map(productoEntityOpt.get(), ProductoDto.class);
		
		return ResponseDto.success(productoDto);
	}

	@Override
	public ResponseDto<Long> add(ProductoDto newObject) {
		ProductoEntity productoEntity = modelMapper.map(newObject, ProductoEntity.class);
		
		ProductoEntity savedEntity = productoRepository.save(productoEntity);
		return ResponseDto.success(savedEntity.getIdProducto());
	}

	@Override
	public ResponseDto<String> update(Long id, ProductoDto newObject) {
		Optional<ProductoEntity> productoEntityOpt = productoRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return ResponseDto.fail("El producto no existe");
		}
		
		ProductoEntity productoEntity = modelMapper.map(newObject, ProductoEntity.class);
		
		productoRepository.save(productoEntity);
		return ResponseDto.success("Producto guardado con éxito");
	}

	@Override
	public ResponseDto<String> delete(Long id) {
		Optional<ProductoEntity> productoEntityOpt = productoRepository.findById(id);
		
		if(productoEntityOpt.isEmpty()) {
			return ResponseDto.fail("El producto no existe");
		}
		
		productoRepository.deleteById(id);
		return ResponseDto.success("Producto eliminado con éxito");
	}

}
