package com.example.loan.serviceinterface;

import java.util.List;

import com.example.loan.dto.UserLoginDTO;
import com.example.loan.message.LoginMessage;
import com.example.loan.model.UserModel;


public interface UserInterface {

	public List<UserModel> getAllUserDetails();
	public UserModel postUserDetails(UserModel id);
	public UserModel putUserDetails(UserModel id);
	public void deleteUserDetails(int id);
	LoginMessage userLogin(UserLoginDTO loginDTO);
}
