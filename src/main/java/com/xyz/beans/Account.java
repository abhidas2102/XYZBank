package com.xyz.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity(name = "Account_Holders")
public class Account {
	
	@Id
	@Column(name = "PAN_Number")
	@Size(min = 6, max =6, message =" Pan number must be of 6 characters")
	private String panNo;
	
	@Column(name = "Account_Number")
	@NotNull
	@Min(value = 10000, message = "Account number must be of 5 digits")
	@Max(value = 99999, message = "Account number must be of 5 digits")
	private int accNo;
	
	@NotNull
	@Size(min = 2, message = "Account name should be atleast 2 characters")
	@Column(name = "Account_Name")
	private String accName;
	
	@Column(name = "City")
	@NotBlank(message = "City should not be blank")
	private String city;
	
	@Column(name = "Balance")
	@Min(value=0, message = "Must be equal or greater than 0")
	private float balance;
	
	@Column(name = "Email")
	@Email(message = "Email should be valid")
	private String email;
	
	public Account() {
		super();
	}

	public Account(@Size(min = 6, max = 6, message = " Pan number must be of 6 characters") String panNo,
			@Min(value = 10000, message = "Account number must be of 5 digits") @Max(value = 99999, message = "Account number must be of 5 digits") int accNo,
			@Size(min = 2, message = "Account name should be atleast 2 characters") String accName,
			@NotBlank(message = "City should not be blank") String city,
			@Min(value = 0, message = "Must be equal or greater than 0") float balance,
			@Email(message = "Email should be valid") String email) {
		super();
		this.panNo = panNo;
		this.accNo = accNo;
		this.accName = accName;
		this.city = city;
		this.balance = balance;
		this.email = email;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [panNo=" + panNo + ", accNo=" + accNo + ", accName=" + accName + ", city=" + city + ", balance="
				+ balance + ", email=" + email + "]";
	}
	
}
