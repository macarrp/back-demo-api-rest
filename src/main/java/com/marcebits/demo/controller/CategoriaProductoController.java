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

import com.marcebits.demo.entity.CategoriaProductoEntity;
import com.marcebits.demo.provider.CategoriaProductoProvider;

@RestController
@RequestMapping("/categorias-producto")
public class CategoriaProductoController {

	@Autowired
	private CategoriaProductoProvider categoriaProductoProvider;
	
	@GetMapping("/")
	public List<CategoriaProductoEntity> getAll() {
		return categoriaProductoProvider.getAll();
	}
	
	@GetMapping("/{idProducto}")
	public CategoriaProductoEntity getSingleCategoria(@PathVariable("idProducto") Long idProducto) {
		return categoriaProductoProvider.getById(idProducto);
	}
	
	@PostMapping("/")
	public Long addCategoria(@RequestBody CategoriaProductoEntity categoria) {
		return categoriaProductoProvider.add(categoria);
	}
	
	@PatchMapping("/{idCategoria}")
	public String editCategoria(
			@PathVariable("idCategoria") Long idCategoria, 
			@RequestBody CategoriaProductoEntity categoria) {
		return categoriaProductoProvider.update(categoria);
	}
	
	@DeleteMapping("/{idCategoria}")
	public String deleteCategoria(@PathVariable("idCategoria") Long idCategoria) {
		return categoriaProductoProvider.delete(idCategoria);
	}
}
