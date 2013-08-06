package com.libchat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.libchat.dao.DAOBuilding;
import com.libchat.dao.DAOManager;
import com.libchat.dao.DAOSchool;
import com.libchat.dao.DAOStudyGroupEvent;
import com.libchat.domain.Building;
import com.libchat.domain.School;
import com.libchat.domain.StudyGroupEvent;

import org.springframework.stereotype.Service;


@Service
public class SchoolServiceImpl implements SchoolService {

  @Autowired
  private DAOManager manager;

  public void setManager(DAOManager manager) {
    this.manager = manager;
  }
  
  public DAOManager getManager() {
    return manager;
  }
  

  public boolean schoolExists(String name) {
    return getManager().getSchoolByName(name) != null;
  }
  
  public boolean createSchool(String name, String mascot, String state) {
    getManager().insertSchool(name, mascot, state);
    
    return true;
  }

  public School getSchool(long id) {
    DAOSchool school = getManager().getSchoolById(id);
    
    if(school == null) {
      return null;
    } else {
      return new School(school);
    }
  }
  
  public School getSchoolByName(String name) {
    DAOSchool school = getManager().getSchoolByName(name);
    
    if(school == null) {
      return null;
    } else {
      return new School(school);
    }
  }
  
  public List<StudyGroupEvent> getEventsAt(String name) {
    DAOSchool school = manager.getSchoolByName(name);
    
    if( school == null ) {
      return new ArrayList<StudyGroupEvent>();
      
    } else {
      List<StudyGroupEvent> list = new ArrayList<StudyGroupEvent>();
      
      for(DAOStudyGroupEvent event : manager.getEventsAtSchool(school.getId())){
        list.add(new StudyGroupEvent(event));
      }
      
      return list;
    }
  }
  
  public Building getBuildingInSchool(String schoolName, Long buildingId) {
    DAOSchool school = manager.getSchoolByName(schoolName);
    if( school == null ) { return null; }
    
    DAOBuilding building = manager.getBuildingInSchoolById(school.getId(), buildingId);
  
    if( building == null ) {
      return null;
    } else {
      return new Building(building);
    }
  }

  public boolean addBuildingAtSchool(String schoolName, int roomNumber) {
    DAOSchool school = manager.getSchoolByName(schoolName);
    
    if( school == null) {
      return false;
    }
    
    manager.insertBuildingAtSchool(school.getId(), roomNumber);
    return true;
  }
}
