package com.xyz.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aadhaar {

	private String aadhaarName;
	
	@Id
	private String aadhaarNumber;
	
	
	public Aadhaar() {
		super();
	}


	public Aadhaar(String aadhaarName, String aadhaarNumber) {
		super();
		this.aadhaarName = aadhaarName;
		this.aadhaarNumber = aadhaarNumber;
	}


	public String getAadhaarName() {
		return aadhaarName;
	}


	public void setAadhaarName(String aadhaarName) {
		this.aadhaarName = aadhaarName;
	}


	public String getAadhaarNumber() {
		return aadhaarNumber;
	}


	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}


	@Override
	public String toString() {
		return "Aadhaar [aadhaarName=" + aadhaarName + ", aadhaarNumber=" + aadhaarNumber + "]";
	}
	
	
}
