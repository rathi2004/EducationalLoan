package com.example.loan.serviceinterface;

import java.util.List;

import com.example.loan.dto.AdminLoginDTO;
import com.example.loan.message.LoginMessage;
import com.example.loan.model.AdminModel;


public interface AdminInterface {
	
	public List<AdminModel> getAllAdminDetails();
	public AdminModel postAdminDetails(AdminModel id);
	public AdminModel putAdminDetails(AdminModel id);
	public void deleteAdminDetails(int id);
	LoginMessage adminLogin(AdminLoginDTO loginDTO);

}
