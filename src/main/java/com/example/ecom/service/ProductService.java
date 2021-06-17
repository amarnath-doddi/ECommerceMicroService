package com.example.ecom.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecom.bean.ProductDTO;
import com.example.ecom.exception.ProductNotfoundException;

@FeignClient(url ="http://localhost:9012/product",value = "productService")
public interface ProductService {
	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getProducts();
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id);
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String categoryName) throws ProductNotfoundException;
	@GetMapping("/name/{name}")
	public ResponseEntity<List<ProductDTO>> getByName(@PathVariable String name);
}
