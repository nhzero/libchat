package com.libchat.services;

import org.springframework.stereotype.Service;


public interface LoginService {
	
	public  boolean checkLogin(String username, String pass);
	public boolean createUser(String username, String pass);

}
