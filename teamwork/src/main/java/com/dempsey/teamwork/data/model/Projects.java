package com.dempsey.teamwork.data.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Projects implements Serializable{

  @SerializedName("STATUS")
  private String status;

  @SerializedName("projects")
  private List<Project> projectList;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Project> getProjectList() {
    return projectList;
  }

  public void setProjectList(List<Project> projectList) {
    this.projectList = projectList;
  }

}
