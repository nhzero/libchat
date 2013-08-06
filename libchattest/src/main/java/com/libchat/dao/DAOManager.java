package com.libchat.dao;

import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Date;

public interface DAOManager {

  // Returns a DAOUser representing the user with the specified userid. 
  // null if no such user is in the database.
  @Select("SELECT * FROM User WHERE id = #{userId}")
  DAOUser getUser(@Param("userId") Long id);
  
  // Inserts a new user into the database.
  @Insert("INSERT INTO User (username,password) VALUES(#{username},#{password})")
  void insertUser(
      @Param("username") String username,
      @Param("password") String passwords);
  
  // Returns the user with a matching names
  @Select("SELECT * FROM User WHERE username = #{userName}")
  DAOUser getUserByName(@Param("userName") String name);
  
  // Returns an Account with the matching accountid
  @Select("SELECT * FROM Account WHERE id = #{accountId}")
  DAOAccount getAccountById(@Param("accountId") Long id);
  
  // Returns a DAOSchool representing the database entry with the corresponding 
  // ids
  @Select("SELECT * FROM School WHERE id = #{schoolId}")
  DAOSchool getSchoolById(@Param("schoolId") Long id);
  
  // Inserts a new school into the database
  @Insert("INSERT INTO School (name,mascot,state) VALUES(#{name},#{mascot},#{state})")
  void insertSchool(
      @Param("name") String name,
      @Param("mascot") String mascot,
      @Param("state") String state);
  
  // Return all events at schoolId
  @Select("SELECT * FROM StudyGroupEvent WHERE id = #{schoolId}")
  List<DAOStudyGroupEvent> getEventsAtSchool(@Param("schoolId") Long id);
  
  // Return all schools in the state
  @Select("SELECT * FROM School WHERE state = #{state}")
  List<DAOSchool> getSchoolsInState(@Param("state") String state);
  
  // Return all known buildings at schoolId
  @Select("SELECT * FROM Building WHERE schoolId = #{schoolId}")
  List<DAOBuilding> getBuildingsInSchool(@Param("schoolId") Long schoolId);
  
  @Select("SELECT * FROM Building WHERE schoolId = #{schoolId} AND buildingId = #{buildingId}")
  DAOBuilding getBuildingInSchoolById(
      @Param("schoolId") Long schoolId,
      @Param("buildingId") Long buildingId);
  
  @Select("SELECT * FROM Building WHERE schoolId = #{schoolId} AND buildingId = #{buildingId}")
  DAOBuilding getBuildingInSchoolByName(
      @Param("schoolId") Long schoolId,
      @Param("buildingId") String buildingId);
  
  // Return a list of all study groups that are happening at school schoolid,
  // and that have any overlap at all with the time range (startTime, endtime)
  // (exclusive).
  @Select(
      "SELECT * FROM (Event as E) INNER JOIN (School as S) " +
      "ON (S.id = E.schoolId) " +
  		"WHERE S.id = #{schoolId} AND (" +
  		  "(E.startTime > #{startTime} AND E.startTime < #{endTime}) " +
  		  "OR (E.endTime > #{startTime} AND E.endTime < #{endTime})" +
  		")")
  List<DAOStudyGroupEvent> getEventsAtSchoolDuringTime(
      @Param("schoolId") Long id, 
      @Param("startTime") Date startTime, 
      @Param("endTime") Date endTime);

  // Returns a school based on the name of that school
  @Select("SELECT * FROM School where name = #{schoolname}")
  DAOSchool getSchoolByName(@Param("schoolname") String name);

  @Insert("INSERT INTO Building (schoolId,roomNumber) VALUES(#{schoolId},#{roomNumber})")
  void insertBuildingAtSchool(
      @Param("schoolId") Long schoolId,
      @Param("roomNumber") int roomNumbers);
}
