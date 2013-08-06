package com.libchat.dao;

public class DAOBuilding extends DAO {
  private static final long serialVersionUID = -858632959071139662L;
  
  private Long schoolId;
  private String name;
  private Integer floor;
  private String room;
  
  public DAOBuilding() {

  }

  public Long getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(Long schoolId) {
    this.schoolId = schoolId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }
}
