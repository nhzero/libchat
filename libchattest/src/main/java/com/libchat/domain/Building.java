package com.libchat.domain;

import com.libchat.dao.DAOBuilding;

public class Building {

  private Long schoolId;
  private String name;
  private Integer floor;
  private String room;
  
  
  public Building() {

  }
  
  public Building(final DAOBuilding building) {
    this.schoolId = building.getSchoolId();
    this.name = building.getName();
    this.floor = building.getFloor();
    this.room = building.getRoom();
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

  public void setName(String number) {
    this.name = number;
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
