package com.libchat.domain;

import java.sql.Date;
import com.libchat.dao.DAOStudyGroupEvent;

public class StudyGroupEvent {
  
  private Long schoolId;
  private Long buildingId;
  private Date startTime;
  private Date endTime;
  private Date postedTime;
  private Long createrId;

  
  public StudyGroupEvent() { 
    
  }
  
  public StudyGroupEvent(final DAOStudyGroupEvent event) {
    this.schoolId = event.getSchoolId();
    this.buildingId = event.getBuildingId();
    this.startTime = event.getStartTime();
    this.endTime = event.getEndTime();
    this.postedTime = event.getPostedTime();
    this.createrId = event.getCreatorId();
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

  public Long getCreaterId() {
    return createrId;
  }

  public void setCreaterId(Long createrId) {
    this.createrId = createrId;
  }
}
