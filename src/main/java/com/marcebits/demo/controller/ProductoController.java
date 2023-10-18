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

import com.marcebits.demo.entity.ProductoEntity;
import com.marcebits.demo.provider.ProductoProvider;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoProvider productoProvider;
	
	@GetMapping("/")
	public List<ProductoEntity> getAll() {
		return productoProvider.getAll();
	}
	
	@GetMapping("/{idProducto}")
	public ProductoEntity getSingleProduct(@PathVariable("idProducto") Long idProducto) {
		return productoProvider.getById(idProducto);
	}
	
	@PostMapping("/")
	public Long addProduct(@RequestBody ProductoEntity producto) {
		return productoProvider.add(producto);
	}
	
	@PatchMapping("/{idProducto}")
	public String editProduct(
			@PathVariable("idProducto") Long ididProducto, 
			@RequestBody ProductoEntity producto) {
		return productoProvider.update(producto);
	}
	
	@DeleteMapping("/{idProducto}")
	public String deleteProduct(@PathVariable("idProducto") Long idProducto) {
		return productoProvider.delete(idProducto);
	}
}
