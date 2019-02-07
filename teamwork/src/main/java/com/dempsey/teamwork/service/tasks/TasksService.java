package com.dempsey.teamwork.service.tasks;

import com.dempsey.teamwork.data.model.ProjectTask;
import com.dempsey.teamwork.data.model.TodoList;

import io.reactivex.Observable;

public interface TasksService {

    Observable<ProjectTask> getTasksForProject(final String projectId);

    Observable<TodoList> getTodoListForTask(final String id);

}
