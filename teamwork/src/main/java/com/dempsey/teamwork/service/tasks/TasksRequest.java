package com.dempsey.teamwork.service.tasks;

import com.dempsey.teamwork.data.model.ProjectTask;
import com.dempsey.teamwork.data.model.TodoList;
import com.dempsey.teamwork.data.net.ApiClient;
import com.dempsey.teamwork.service.BaseRequest;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import io.reactivex.Observable;

public class TasksRequest extends BaseRequest<TasksService> {

    private static class TaskRequestLoader {
        private static final TasksRequest INSTANCE = new TasksRequest();
    }

    @Override
    public void init(ApiClient apiClient) {
        this.service = new TasksServiceImpl(apiClient, gson);
    }

    private TasksRequest() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();
    }

    public static TasksRequest getInstance() {
        return TaskRequestLoader.INSTANCE;
    }

    public Observable<ProjectTask> getAllTasksForProject(final String projectId) {
        return service.getTasksForProject(projectId);
    }

    public Observable<TodoList> getTodoListForTask(final String id) {
        return service.getTodoListForTask(id);
    }
}
