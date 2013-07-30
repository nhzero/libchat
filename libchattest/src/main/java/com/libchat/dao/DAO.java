package com.libchat.dao;

import java.io.Serializable;

public abstract class DAO implements Serializable {
  private static final long serialVersionUID = -348592038800441060L;
  
  protected Long id;  
  
  public DAO() { } 
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
}
