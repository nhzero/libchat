package com.libchat.domain;

import com.libchat.dao.DAOSchool;

public class School {
  
  private String name;
  private String mascot;
  private String state;
  

  public School() { 
    
  }
  
  public School(final DAOSchool school)
  {
    this.name = school.getName();
    this.mascot = school.getMascot();
    this.state = school.getState();
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
