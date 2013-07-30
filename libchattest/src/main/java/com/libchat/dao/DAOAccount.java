package com.libchat.dao;

public class DAOAccount extends DAO {
  private static final long serialVersionUID = -2295828782810748962L;
  
  private Long userId;
  private String email;
  private Long schoolId;
  private String profileImage;
  
  public DAOAccount() {
    
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(Long schoolId) {
    this.schoolId = schoolId;
  }

  public String getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }
}
