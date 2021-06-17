package com.example.ecom.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecom.bean.OrderDTO;
import com.example.ecom.exception.OrderNotfoundException;

@FeignClient(url ="http://localhost:9013/order",value = "orderService")
public interface OrderService {
	@GetMapping("/")
	public ResponseEntity<List<OrderDTO>> getOrders();
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id);
	@PostMapping("/")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order);
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<OrderDTO>> getOrdersByUserId(@PathVariable Long userId) throws OrderNotfoundException;
	@GetMapping("/date/{orderDate}")
	public ResponseEntity<List<OrderDTO>> getOrdersByOrderDate(@PathVariable LocalDate orderDate) throws OrderNotfoundException;
	@PostMapping("/order/checkout/")
	public ResponseEntity<OrderDTO> orderCheckOut(@RequestBody OrderDTO order);
	@GetMapping("/date/{startDate}/{endDate}")
	public ResponseEntity<List<OrderDTO>> getOrdersByOrderDateBetween(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate);
}
