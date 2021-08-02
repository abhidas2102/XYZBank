package com.xyz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.beans.Aadhaar;
import com.xyz.beans.Account;
import com.xyz.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/createaccount")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createAccount(@Valid @RequestBody Account a) {
		service.createAccount(a);
	}
	
	@GetMapping("/viewaccount/{pan}")
	public Account viewAccount(@PathVariable String pan) {
		Account account = service.getAccount(pan);
		return account;
	}
	
	@PutMapping("/updateaccount")
	public void updateAccount(@RequestBody Account a)
	{
		service.updateAccount(a);
		
	}
	
	@DeleteMapping("/deleteaccount/{pan}")
	public void deleteAccount(@PathVariable String pan)
	{
		service.deleteAccount(pan);
	}
	
	@GetMapping("/deposit/{pan}/{amount}")
	public float deposit(@PathVariable String pan,@PathVariable String amount)
	{
		float famount = Float.parseFloat(amount);
		float newBalance = service.deposit(pan, famount);
		return newBalance;
	}
	
	@GetMapping("/withdraw/{pan}/{amount}")
	public float withdraw(@PathVariable String pan,@PathVariable String amount)
	{
		float famount = Float.parseFloat(amount);
		float newBalance = service.withdraw(pan, famount);
		return newBalance;
	}
	
	@GetMapping("viewaadhaar/{aadhaarNumber}")
	public String getAadhaar(@PathVariable String aadhaarNumber) {
		return service.getAadhaar(aadhaarNumber);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	   Map<String, String> errors = new HashMap<>();
	 
	   ex.getBindingResult().getFieldErrors().forEach(error ->
	           errors.put(error.getField(), error.getDefaultMessage()));
	 
	   return errors;
	}
}
