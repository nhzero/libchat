package com.libchat.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libchat.dao.*;

@Service
public class LoginServiceImpl implements LoginService {
	
  @Autowired
	private DAOManager manager;

  public void setManager(DAOManager manager) {
    this.manager = manager;
  }
  
  public DAOManager getManager() {
    return manager;
  }

  
  public boolean checkLogin(String username, String pass) {
    DAOManager tempManager = getManager();
    System.out.println("Manager address: " + tempManager);
    
	  DAOUser user = getManager().getUserByName(username);
	  
	  if( user == null )
		{
		  return false;
		}

		if( user.getPassword().equals(pass) ) {
			return true;
		}
		else 
	  {
			return false;
		}
	}
	
	public boolean checkIfLoginExists(String username) {
	  DAOUser user = getManager().getUserByName(username);
	  
	  if( user == null )
  	{  
  	  return false;
  	}
  	  else
  	{
  	  return true;
  	}
	}
	

	public boolean createUser(String username, String pass, String email) {
	  if(!checkLogin(username, pass))
	  {
	    return false;
	  }
	  else
	  {
	    getManager().insertUser(username, pass);
	  
	    return true;
	  }
	}
}