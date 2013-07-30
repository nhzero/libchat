package com.libchat.dao;

import java.sql.Date;

public class DAOUser extends DAO {
  private static final long serialVersionUID = 6108768955415227186L;
  
  private String username;
  private String password;
  private Date deleted;

  public DAOUser() {
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
