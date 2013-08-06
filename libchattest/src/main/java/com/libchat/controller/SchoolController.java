package com.libchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libchat.domain.Building;
import com.libchat.domain.School;
import com.libchat.domain.StudyGroupEvent;
import com.libchat.services.SchoolServiceImpl;

@Controller
@RequestMapping("/school")
public class SchoolController {

  
  @Autowired
  private SchoolServiceImpl service;
  
  
  @RequestMapping(value="/fromname", method = {RequestMethod.GET, RequestMethod.POST})
  public @ResponseBody String getSchoolByName(
      @RequestParam("name") String name,
      ModelMap model)
  {
    School school = service.getSchoolByName(name);
    
    return
        school.getName() + ", "
      + school.getMascot() + ", "
      + school.getState();
  }
  
  
  @RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody String insertSchool(
      @RequestParam("name") String name,
      @RequestParam("mascot") String mascot,
      @RequestParam("state") String state,
      ModelMap model)
  {
    if( service.schoolExists(name) ) {
      return "School with same name exists!";
      
    } else { 
    
      service.createSchool(name, mascot, state);
      return "Success!";
    }
  }
  
  
  @RequestMapping(value="/addbuilding", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody String addBuilding(
      @RequestParam("schoolname") String schoolName,
      @RequestParam("roomnumber") int roomNumber,
      ModelMap model)
  {
    return new Boolean(
        service.addBuildingAtSchool(schoolName, roomNumber)).toString();
  }
  
  
  @RequestMapping(value="/events/getall", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody String getEventsAtSchool(
      @RequestParam("name") String name,
      ModelMap model)
  {
    School school = service.getSchoolByName(name);
    if( school == null ) { return "No school by that name!"; }
    
    List<StudyGroupEvent> events = service.getEventsAt(name);
  
    if(events.size() == 0){ return "No Events!"; }
    
    String retval = "";
    
    for(StudyGroupEvent event : events ) {
      Building building = service.getBuildingInSchool(name, event.getBuildingId());
    
      retval += (
          "From"
          + event.getStartTime() 
          + " to "
          + event.getEndTime()
          + ", in room "
          + building.getRoom() 
          + "\n");
    }
    
    return retval;
  }
  
  
  @RequestMapping(value="/events/add", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody String addEvent(
      @RequestParam("schoolname") String schoolname,
      @RequestParam("roomnumber") int roomnumber,
      @RequestParam("startTime") String startTime,
      @RequestParam("endTime") String endTime,
      @RequestParam("creatorId") String creatorId,
      ModelMap model)
  {
    School school = service.getSchoolByName(schoolname);
    if( school == null) { return "No school by that name!"; }
    
    //Building building = service.getBuildingInSchool(
    //    schoolname, 
    //    buildingId);
    
    return "false";
  }
}
