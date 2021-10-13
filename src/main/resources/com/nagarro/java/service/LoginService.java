package com.nagarro.training.service;


import org.springframework.stereotype.Service;




@Service
public class LoginService {
	
	public Boolean loginAuthentication(String username, String password) {
		
		if (username.equals("admin") && password.equals("abc123")) {
			return true;
		}
		return false;
	}

}
