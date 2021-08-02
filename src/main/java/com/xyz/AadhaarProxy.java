package com.xyz;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xyz.beans.Aadhaar;

@FeignClient(name = "aadhaar")
public interface AadhaarProxy {
	@GetMapping("viewaadhaar/{aadhaarNumber}")
	public Aadhaar getAadhaar(@PathVariable String aadhaarNumber);

}
