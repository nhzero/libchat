package com.libchat.services;


public interface LoginService {
	
	public boolean checkLogin(String username, String pass);
	public boolean createUser(String username, String pass, String email);

}
