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

import com.marcebits.demo.dto.ProductoDto;
import com.marcebits.demo.provider.ProductoProvider;
import com.marcebits.demo.utils.ResponseDto;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoProvider productoProvider;
	
	@GetMapping("/")
	public ResponseDto<List<ProductoDto>> getAll() {
		return productoProvider.getAll();
	}
	
	@GetMapping("/{idProducto}")
	public ResponseDto<ProductoDto> getSingleProduct(@PathVariable("idProducto") Long idProducto) {
		return productoProvider.getById(idProducto);
	}
	
	@PostMapping("/")
	public ResponseDto<Long> addProduct(@RequestBody ProductoDto producto) {
		return productoProvider.add(producto);
	}
	
	@PatchMapping("/{idProducto}")
	public ResponseDto<String> editProduct(
			@PathVariable("idProducto") Long idProducto, 
			@RequestBody ProductoDto producto) {
		return productoProvider.update(idProducto, producto);
	}
	
	@DeleteMapping("/{idProducto}")
	public ResponseDto<String> deleteProduct(@PathVariable("idProducto") Long idProducto) {
		return productoProvider.delete(idProducto);
	}
}
