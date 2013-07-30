package com.libchat.dao;

public class DAOSchool extends DAO {
  private static final long serialVersionUID = 7702194079175038065L;
  
  private String name;
  private String mascot;
  private String state;


  public DAOSchool() {

  }
  
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMascot() {
    return mascot;
  }

  public void setMascot(String mascot) {
    this.mascot = mascot;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
