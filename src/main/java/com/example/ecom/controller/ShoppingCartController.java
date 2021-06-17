package com.example.ecom.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.bean.BalanceTransfer;
import com.example.ecom.bean.BeneficiaryDTO;
import com.example.ecom.bean.OrderDTO;
import com.example.ecom.bean.ProductDTO;
import com.example.ecom.bean.UserAccountDTO;
import com.example.ecom.bean.UserDTO;
import com.example.ecom.exception.OrderNotfoundException;
import com.example.ecom.exception.ProductNotfoundException;
import com.example.ecom.service.FundService;
import com.example.ecom.service.OrderService;
import com.example.ecom.service.ProductService;
import com.example.ecom.service.UserService;
@RestController
public class ShoppingCartController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private FundService fundService;
	
	@GetMapping("/user/login")
	public ResponseEntity<Boolean> login(@RequestParam String loginId,@RequestParam String password){
		return userService.login(loginId, password);
	}
	@PostMapping("/user")
	public ResponseEntity<UserDTO> userRegistration(@RequestBody UserDTO user){
		return userService.createUser(user);
	}
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getProducts(){
		return productService.getProducts();
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
		return productService.getProduct(id);
	}
	@GetMapping("/product/category/{categoryName}")
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String categoryName) throws ProductNotfoundException{
		return productService.getProductsByCategory(categoryName);
	}
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> getOrders(){
		return orderService.getOrders();
	}
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDTO> getOrders(@PathVariable Long id){
		return orderService.getOrder(id);
	}
	@GetMapping("/order/userId/{userId}")
	public ResponseEntity<List<OrderDTO>> getOrdersByUserId(@PathVariable Long userId) throws OrderNotfoundException{
		return orderService.getOrdersByUserId(userId);
	}
	@GetMapping("/order/loginId/{loginId}")
	public ResponseEntity<List<OrderDTO>> getOrdersByLoginId(@PathVariable String loginId) throws OrderNotfoundException{
		UserDTO user = userService.getUserByLoginId(loginId).getBody();
		return orderService.getOrdersByUserId(user.getId());
	}
	@GetMapping("/order/date/{orderDate}")
	public ResponseEntity<List<OrderDTO>> getOrdersByOrderDate(@PathVariable LocalDate orderDate) throws OrderNotfoundException{
		return orderService.getOrdersByOrderDate(orderDate);
	}
	@GetMapping("/order/date/{startDate}/{endDate}")
	public ResponseEntity<List<OrderDTO>> getOrdersByOrderDateBetween(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate){
		return orderService.getOrdersByOrderDateBetween(startDate, endDate);
	}
	@PostMapping("/order/checkout")
	public ResponseEntity<OrderDTO> orderCheckOut(@RequestBody OrderDTO order){
		return orderService.orderCheckOut(order);
	}
	@GetMapping("/beneficiary")
	public ResponseEntity<List<BeneficiaryDTO>> getBeneficiaries(){
		return fundService.getBeneficiaries();
	}
	@GetMapping("/beneficiary/{id}")
	public ResponseEntity<BeneficiaryDTO> getBeneficiary(@PathVariable Long id){
		return fundService.getBeneficiary(id);
	}
	@GetMapping("/account/")
	public ResponseEntity<List<UserAccountDTO>> getAccounts(){
		return fundService.getAccounts();
	}
	@GetMapping("/account/user/{userId}")
	public ResponseEntity<UserAccountDTO> getAccountByUserId(@PathVariable Long userId){
		return fundService.getAccountByUserId(userId);
	}
	@PutMapping("/fund/transfer/account/")
	public ResponseEntity<Boolean> transferToAccount(@RequestBody BalanceTransfer fundTransfer){
		return fundService.transferToAccount(fundTransfer);
	}
	@GetMapping("/product/name/{name}")
	public ResponseEntity<List<ProductDTO>> getByName(@PathVariable String name){
		return productService.getByName(name);
	}
}
