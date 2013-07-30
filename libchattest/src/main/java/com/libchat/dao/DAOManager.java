package com.libchat.dao;

import org.apache.ibatis.annotations.*;

public interface DAOManager {

  @Select("SELECT * FROM User WHERE id = #{userId}")
  DAOUser getUser(@Param("userId") Long id);
  
  @Insert("INSERT INTO User (username, password) VALUES(#{username},#{password}")
  void insertUser(@Param("username") String username, @Param("password") String passwords);
  
  @Select("SELECT * FROM User WHERE username = #{userName}")
  DAOUser getUserByName(@Param("userName") String name);
  
  //@Select("SELECT * FROM Account WHERE id = #{accountId}")
  //DAOAccount getAccountById(@Param("accountId") Long id);
  
  /*
  DAOSchool getSchoolById(Long id);
  
  List<DAOStudyGroupEvent> getEventsAtSchool(Long id);
  
  List<DAOSchool> getSchoolsInState(String state);
  
  List<DAOBuilding> getBuildingsInSchool(Long id);
  
  List<DAOStudyGroupEvent> getEventsAtSchoolDuringTime(
      Long id, 
      Date startTime, 
      Date endTime);
      */
}
