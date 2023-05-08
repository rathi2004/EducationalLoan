package com.example.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.dto.AdminLoginDTO;
import com.example.loan.message.LoginMessage;
import com.example.loan.model.AdminModel;
import com.example.loan.repository.AdminRepository;
import com.example.loan.serviceinterface.AdminInterface;

@Service
public class AdminService implements AdminInterface {

	@Autowired
	AdminRepository ar;
	@Override
	public List<AdminModel> getAllAdminDetails() {
		
		return ar.findAll();
	}

	@Override
	public AdminModel postAdminDetails(AdminModel id) {
		
		return ar.save(id);
	}

	@Override
	public AdminModel putAdminDetails(AdminModel id) {
		
		return ar.save(id);
	}

	@Override
	public void deleteAdminDetails(int id) {
		
		 ar.deleteById(id);
	}

	@Override
	public LoginMessage adminLogin(AdminLoginDTO loginDTO) {
		
		AdminModel user1 = ar.findByEmail(loginDTO.getEmail());
        
       
        
        if (user1 != null) {
        	
            String password = loginDTO.getPassword();
    
            if (password.equals(password)) {
            	
                Optional<AdminModel> user = ar.findOneByEmailAndPassword(loginDTO.getEmail(), password);
                
                if (user.isPresent()) {
                	
                    return new LoginMessage("Login Success", true);
                    
                } 
                else {
                	
                    return new LoginMessage("Password not match", false);
                }
            } 
            else {
 
                return new LoginMessage("Email not exist", false);
            }
        }
        else {
        	
            return new LoginMessage("check your email and password", false);
        }
 
 
    }
	}

