
package com.example.loan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="email",unique=true,nullable=false)
	private String email;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="mobile_number",unique=true,nullable=false)
	private String mobileNumber;
	@Column(name="user_roll",nullable=false)
	private String userRoll;
	
	UserModel(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}

	public UserModel(int id, String email, String password, String username, String mobileNumber, String userRoll) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.userRoll = userRoll;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", mobileNumber=" + mobileNumber + ", userRoll=" + userRoll + "]";
	}
	
	
	
}
