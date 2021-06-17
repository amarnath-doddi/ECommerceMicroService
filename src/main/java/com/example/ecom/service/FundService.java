package com.example.ecom.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecom.bean.BalanceTransfer;
import com.example.ecom.bean.BeneficiaryDTO;
import com.example.ecom.bean.FundTransfer;
import com.example.ecom.bean.UserAccountDTO;

@FeignClient(url ="http://localhost:9014/fund",value = "fundService")
public interface FundService {
	@PutMapping("/")
	public ResponseEntity<Boolean> transfer(@RequestBody FundTransfer fundTransfer);
	@GetMapping("/beneficiary/")
	public ResponseEntity<List<BeneficiaryDTO>> getBeneficiaries();
	@GetMapping("/beneficiary/{id}")
	public ResponseEntity<BeneficiaryDTO> getBeneficiary(@PathVariable Long id);
	@PostMapping("/account/")
	public ResponseEntity<UserAccountDTO> createAccount(@RequestBody UserAccountDTO account);
	@GetMapping("/account/")
	public ResponseEntity<List<UserAccountDTO>> getAccounts();
	@GetMapping("/account/user/{userId}")
	public ResponseEntity<UserAccountDTO> getAccountByUserId(@PathVariable Long userId);
	@PutMapping("/account/")
	public ResponseEntity<Boolean> transferToAccount(@RequestBody BalanceTransfer fundTransfer);
}
