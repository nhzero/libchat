package com.libchat.domain;

import java.sql.Date;

import com.libchat.dao.DAOUser;

public class User {

  private String username;
  private String password;
  private Date deleted;
  
  public User() {
    
  }
  
  public User(DAOUser user) {
    password = user.getPassword();
    username = user.getUsername();
    deleted = user.getDeleted();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getDeleted() {
    return deleted;
  }

  public void setDeleted(Date deleted) {
    this.deleted = deleted;
  }
}
