package com.libchat.domain;

import com.libchat.dao.DAOBuilding;

public class Building {

  private Long schoolId;
  private Long number;
  private Integer floor;
  private String room;
  
  
  public Building() {

  }
  
  public Building(final DAOBuilding building) {
    this.schoolId = building.getSchoolId();
    this.number = building.getNumber();
    this.floor = building.getFloor();
    this.room = building.getRoom();
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
