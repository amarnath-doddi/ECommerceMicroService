package com.example.ecom.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecom.bean.UserDTO;
import com.example.ecom.exception.InvalidCredentialsException;

@FeignClient(url ="http://localhost:9011/users",value = "userService")
public interface UserService {
	@GetMapping("/login")
	public ResponseEntity<Boolean> login(@RequestParam String loginId,@RequestParam String password) throws InvalidCredentialsException;
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user);
	@GetMapping("/loginId/{loginId}")
	public ResponseEntity<UserDTO> getUserByLoginId(@PathVariable String loginId);
}
