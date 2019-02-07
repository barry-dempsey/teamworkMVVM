package com.dempsey.teamwork.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProjectTask {
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("tasklists")
    @Expose
    private List<Task> tasks;

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
