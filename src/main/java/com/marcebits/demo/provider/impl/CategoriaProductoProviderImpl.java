package com.marcebits.demo.provider.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcebits.demo.dto.CategoriaProductoDto;
import com.marcebits.demo.entity.CategoriaProductoEntity;
import com.marcebits.demo.provider.CategoriaProductoProvider;
import com.marcebits.demo.repository.CategoriaProductoRepository;
import com.marcebits.demo.utils.ResponseDto;

@Component
public class CategoriaProductoProviderImpl implements CategoriaProductoProvider {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private CategoriaProductoRepository productoCategoriaRepository;
	
	@Override
	public ResponseDto<List<CategoriaProductoDto>> getAll() {
		List<CategoriaProductoEntity> categoriasEntity = productoCategoriaRepository.findAll();
		
		List<CategoriaProductoDto> categoriasDto = new ArrayList<>();
		
		categoriasEntity.forEach(prod -> {
			categoriasDto.add(
					modelMapper.map(prod, CategoriaProductoDto.class)
			);			
		});
		;
		
		return ResponseDto.success(categoriasDto);
	}

	@Override
	public ResponseDto<CategoriaProductoDto> getById(Long id) {
		Optional<CategoriaProductoEntity> categoriaEntityOpt = productoCategoriaRepository.findById(id);
		
		if(categoriaEntityOpt.isEmpty()) {
			return ResponseDto.fail("La categoria no existe");
		}
		
		CategoriaProductoDto categoriaDto = modelMapper.map(categoriaEntityOpt.get(), CategoriaProductoDto.class);
		
		return ResponseDto.success(categoriaDto);
	}

	@Override
	public ResponseDto<Long> add(CategoriaProductoDto newObject) {
		CategoriaProductoEntity categoriaEntity = modelMapper.map(newObject, CategoriaProductoEntity.class);
		
		CategoriaProductoEntity savedEntity = productoCategoriaRepository.save(categoriaEntity);
		return ResponseDto.success(savedEntity.getIdCategoria());
	}

	@Override
	public ResponseDto<String> update(Long id, CategoriaProductoDto newObject) {
		Optional<CategoriaProductoEntity> categoriaEntityOpt = productoCategoriaRepository.findById(id);
		
		if(categoriaEntityOpt.isEmpty()) {
			return ResponseDto.fail("La categoria no existe");
		}
		
		CategoriaProductoEntity categoriaEntity = modelMapper.map(newObject, CategoriaProductoEntity.class);
		productoCategoriaRepository.save(categoriaEntity);
		
		return ResponseDto.success("Categoria guardado con éxito");
	}

	@Override
	public ResponseDto<String> delete(Long id) {
		Optional<CategoriaProductoEntity> categoriaEntityOpt = productoCategoriaRepository.findById(id);
		
		if(categoriaEntityOpt.isEmpty()) {
			return ResponseDto.fail("La categoria no existe");
		}
		
		productoCategoriaRepository.deleteById(id);
		return ResponseDto.success("Categoria eliminado con éxito");
	}

}
