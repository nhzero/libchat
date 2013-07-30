package com.libchat.domain;
import com.libchat.dao.DAOAccount;

public class Account {

  private Long userId;
  private String email;
  private Long schoolId;
  private String profileImage;

  
  public Account() {

  }
  
  public Account(final DAOAccount account)
  {
   this.userId = account.getUserId();
   this.email = account.getEmail();
   this.schoolId = account.getSchoolId();
   this.profileImage = account.getProfileImage();
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
