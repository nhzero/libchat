package com.libchat.services;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
	
	
	private JdbcTemplate  jdbc;
	
	public boolean checkLogin(String username, String pass) {
		
		if(jdbc == null ) {
			return false;
		}
		try {
			String password = (String) getJdbcTemplate().queryForObject("select password from user where username = ?", new Object[]{username}, String.class);
		
			if(password == null){
				return false;
			}
			if( pass.equals(password) ) {
				return true;
			}
			else {
				return false;
			}
		}	
		catch(EmptyResultDataAccessException e) {
			return false;
		}
		
	}
	
	public boolean checkIfLoginExists(String username) {
		
		if(jdbc == null ) {
			return false;
		}
		try{
			String password = (String) getJdbcTemplate().queryForObject("select username from user where username = ?", new Object[]{username}, String.class);
			
			if(password == null){
				return false;
			}
			if( password.equals(username) ) {
				return true;
			}
			else {
				return false;
			}
		}	
		catch(EmptyResultDataAccessException e) {
			return false;
		}
		
		
	}
	
	@Autowired
	void setDataSource(BasicDataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbc;
	}
	
	public boolean createUser(String username, String pass) {
		if(jdbc == null){
			return false;
		}
		
		int user = (int) getJdbcTemplate().queryForObject("select count(*) from user where username = ?", new Object[]{username}, Integer.class);
		
		if( user > 0 ) {
			return false;
		} else {
			int updated = getJdbcTemplate().update("insert into user (username, password) values(? ,?)", new Object[]{username,pass});
			if( updated > 0 ) {
				return true;
			} else {
				return false;
			}
		}
	}
	

}