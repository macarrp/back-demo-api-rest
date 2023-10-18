package com.marcebits.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcebits.demo.dto.CategoriaProductoDto;
import com.marcebits.demo.provider.CategoriaProductoProvider;
import com.marcebits.demo.utils.ResponseDto;

@RestController
@RequestMapping("/categorias-producto")
public class CategoriaProductoController {

	@Autowired
	private CategoriaProductoProvider categoriaProductoProvider;
	
	@GetMapping("/")
	public ResponseDto<List<CategoriaProductoDto>> getAll() {
		return categoriaProductoProvider.getAll();
	}
	
	@GetMapping("/{idProducto}")
	public ResponseDto<CategoriaProductoDto> getSingleCategoria(@PathVariable("idProducto") Long idProducto) {
		return categoriaProductoProvider.getById(idProducto);
	}
	
	@PostMapping("/")
	public ResponseDto<Long> addCategoria(@RequestBody CategoriaProductoDto categoria) {
		return categoriaProductoProvider.add(categoria);
	}
	
	@PatchMapping("/{idCategoria}")
	public ResponseDto<String> editCategoria(
			@PathVariable("idCategoria") Long idCategoria, 
			@RequestBody CategoriaProductoDto categoria) {
		return categoriaProductoProvider.update(idCategoria, categoria);
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseDto<String> deleteCategoria(@PathVariable("idCategoria") Long idCategoria) {
		return categoriaProductoProvider.delete(idCategoria);
	}
}
