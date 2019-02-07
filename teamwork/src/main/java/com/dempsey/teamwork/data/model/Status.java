package com.dempsey.teamwork.data.model;

import com.google.gson.annotations.SerializedName;

public class Status {

  @SerializedName("STATUS")
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
