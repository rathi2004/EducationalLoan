package com.example.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.dto.UserLoginDTO;
import com.example.loan.message.LoginMessage;
import com.example.loan.model.UserModel;
import com.example.loan.repository.UserRepository;
import com.example.loan.serviceinterface.UserInterface;

@Service

public class UserService implements UserInterface {

	@Autowired
	UserRepository ur;

	@Override
	public List<UserModel> getAllUserDetails() {
		
		return ur.findAll();
	}

	@Override
	public UserModel postUserDetails(UserModel id) {
		
		return ur.save(id);
	}

	@Override
	public UserModel putUserDetails(UserModel id) {
		
		return ur.save(id);
	}

	@Override
	public void deleteUserDetails(int id) {
		
		ur.deleteById(id);
	}
	
	@Override
    public LoginMessage userLogin(UserLoginDTO loginDTO) {
    	
       
        UserModel user1 = ur.findByEmail(loginDTO.getEmail());
        
       
        
        if (user1 != null) {
        	
            String password = loginDTO.getPassword();
    
            if (password.equals(password)) {
            	
                Optional<UserModel> user = ur.findOneByEmailAndPassword(loginDTO.getEmail(), password);
                
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
