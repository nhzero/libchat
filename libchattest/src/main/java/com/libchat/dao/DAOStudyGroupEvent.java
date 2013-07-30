package com.libchat.dao;

import java.sql.Date;

public class DAOStudyGroupEvent extends DAO{
  private static final long serialVersionUID = 260639090896017335L;
  
  private Long schoolId;
  private Long buildingId;
  private Date startTime;
  private Date endTime;
  private Date postedTime;
  private Long creatorId;
  
  
  public DAOStudyGroupEvent() {
    
  }

  
  public Long getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(Long schoolId) {
    this.schoolId = schoolId;
  }

  public Long getBuildingId() {
    return buildingId;
  }

  public void setBuildingId(Long buildingId) {
    this.buildingId = buildingId;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getPostedTime() {
    return postedTime;
  }

  public void setPostedTime(Date postedTime) {
    this.postedTime = postedTime;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreaterId(Long creatorId) {
    this.creatorId = creatorId;
  }
}
