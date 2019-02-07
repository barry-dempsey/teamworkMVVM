package com.dempsey.teamwork.service.tasks;

import com.dempsey.teamwork.data.model.ProjectTask;
import com.dempsey.teamwork.data.model.TodoList;
import com.dempsey.teamwork.data.net.ApiClient;
import com.dempsey.teamwork.service.Util;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class TasksServiceImpl implements TasksService {

    private static final String TASKS_WITH_ID_URL_PATH = "/projects/%s/tasklists.json";
    private static final String SINGLE_TASK_LIST_PATH = "/tasklists/%s.json";
    private final ApiClient apiClient;
    private final Gson gson;

    TasksServiceImpl(final ApiClient apiClient, final Gson gson) {
        this.apiClient = apiClient;
        this.gson = gson;
    }

    @Override
    public Observable<ProjectTask> getTasksForProject(final String projectId) {
        return apiClient.withPath(projectsUrlPath(projectId))
                .get()
                .map(Util::getContent)
                .map(content -> gson.fromJson(content, ProjectTask.class));
    }

    @Override
    public Observable<TodoList> getTodoListForTask(final String id) {
        return apiClient.withPath(todoListUrlPath(id))
                .get()
                .map(Util::getContent)
                .map(content -> gson.fromJson(content, TodoList.class));
    }

    private String projectsUrlPath(@NonNull String projectId) {
        return String.format(TASKS_WITH_ID_URL_PATH, projectId);
    }

    private String todoListUrlPath(@NonNull String taskId) {
        return String.format(SINGLE_TASK_LIST_PATH, taskId);
    }
}
