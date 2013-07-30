package com.libchat.dao;

public class DAOBuilding extends DAO {
  private static final long serialVersionUID = -858632959071139662L;
  
  private Long schoolId;
  private Long number;
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

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
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
