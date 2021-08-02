package com.xyz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.AadhaarProxy;
import com.xyz.beans.Account;
import com.xyz.repositories.AccountsRepository;

@Service
public class AccountService {
	@Autowired
	AccountsRepository repo;
	
	@Autowired
	AadhaarProxy aadhaarProxy;

	public void createAccount(Account acc) {
		repo.save(acc);
	}

	public Account getAccount(String pan) {
		Account temp = new Account();
		temp.setAccName("Account Not Present");
		Optional<Account> account = repo.findById(pan);
		if(account.isPresent()) {
			return account.get();
		}
		return temp;
	}
	
	public void updateAccount(Account acc)
	{
		repo.save(acc);
	}
	
	public void deleteAccount(String pan)
	{
		repo.deleteById(pan);
	}
	
	public float deposit(String pan, float balance)
	{
		Account a = getAccount(pan);
		a.setBalance(a.getBalance()+balance);
		updateAccount(a);	
		
		return a.getBalance();
	}
	
	public float withdraw(String pan, float balance)
	{
		Account a = getAccount(pan);
		a.setBalance(a.getBalance()-balance);
		updateAccount(a);
		
		return a.getBalance();
	}
	
	public String getAadhaar(String aadhaarNumber)
	{
		return aadhaarProxy.getAadhaar(aadhaarNumber).getAadhaarNumber();
	}
	
}
