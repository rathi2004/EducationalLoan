package com.example.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.dto.AdminLoginDTO;
import com.example.loan.message.LoginMessage;
import com.example.loan.model.AdminModel;
import com.example.loan.service.AdminService;

@CrossOrigin("*")
@RestController
public class AdminController {

    @Autowired	
	AdminService as;
    
    @GetMapping("/getalladmin")
	
	public List<AdminModel> getAllUserDetails(){
		
		return as.getAllAdminDetails();
	}
	
	@PostMapping("/postadmindetails")
	
	public AdminModel postUser(@RequestBody AdminModel id) {
		
		return as.postAdminDetails(id);
		
	}
	

	
	@PutMapping("/putadmindetails")
	public String putUserDetails(@RequestBody AdminModel id) {
		
		as.putAdminDetails(id);
		return "User details are Updated";
		
	}
	
	@DeleteMapping("/deleteadmindetails")
	public String deleteUserDetails(@RequestParam int id) {
		
		as.deleteAdminDetails(id);
		return "User Details are deleted";
	}
	
	@PostMapping("/adminlogin")
    public ResponseEntity<?> adminLogin(@RequestBody AdminLoginDTO loginDTO)
    {
   	 LoginMessage loginMessage=as.adminLogin(loginDTO);
   	 
   	 return ResponseEntity.ok(loginMessage);
    }
	
}
