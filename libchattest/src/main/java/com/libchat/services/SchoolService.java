package com.libchat.services;

import com.libchat.domain.School;

public interface SchoolService {

  public boolean createSchool(String name, String mascot, String state);
  public School getSchool(long id);
}
