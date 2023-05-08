
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

import com.example.loan.dto.UserLoginDTO;
import com.example.loan.message.LoginMessage;
import com.example.loan.model.UserModel;
import com.example.loan.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService us;
	
	
	
@GetMapping("/getalluser")
	
	public List<UserModel> getAllUserDetails(){
		
		return us.getAllUserDetails();
	}
	
	@PostMapping("/postuserdetails")
	
	public UserModel postUser(@RequestBody UserModel id) {
		
		return us.postUserDetails(id);
		
	}
	

	
	@PutMapping("/putuserdetails")
	public String putUserDetails(@RequestBody UserModel id) {
		
		us.putUserDetails(id);
		return "User details are Updated";
		
	}
	
	@DeleteMapping("/deleteuserdetails")
	public String deleteUserDetails(@RequestParam int id) {
		
		us.deleteUserDetails(id);
		return "User Details are deleted";
	}
	
	@PostMapping("/userlogin")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO loginDTO)
    {
   	 LoginMessage loginMessage=us.userLogin(loginDTO);
   	 
   	 return ResponseEntity.ok(loginMessage);
    }
	

	
	

}
