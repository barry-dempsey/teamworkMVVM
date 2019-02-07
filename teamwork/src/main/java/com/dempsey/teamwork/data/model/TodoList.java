package com.dempsey.teamwork.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TodoList implements Serializable {
    @SerializedName("todo-list")
    @Expose
    private TodoList_ todoList;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;

    public TodoList_ getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList_ todoList) {
        this.todoList = todoList;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }
}
