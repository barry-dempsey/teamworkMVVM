package com.dempsey.teamwork.service.project;

import com.dempsey.teamwork.data.model.Project;
import com.dempsey.teamwork.data.model.Projects;
import com.dempsey.teamwork.data.net.ApiClient;
import com.dempsey.teamwork.service.BaseRequest;
import com.dempsey.teamwork.service.RequestCallback;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import java.lang.reflect.Modifier;
import java.util.List;
import okhttp3.Response;

public final class ProjectRequest extends BaseRequest<ProjectService> {

    private static class ProjectRequestLoader {
        private static final ProjectRequest INSTANCE = new ProjectRequest();
    }

    public void init(final ApiClient apiClient) {
        this.service = new ProjectServiceImpl(apiClient, gson);
    }

    private ProjectRequest() {
        if (ProjectRequestLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();
    }

    public static ProjectRequest getInstance() {
        return ProjectRequestLoader.INSTANCE;
    }

    public void newGetAllProjectsRequest(RequestCallback<List<Project>> callback) {
        service.getAllProjects(callback);
    }

    public Observable<Projects> newGetAllProjectsRequest() {
        return service.getAllProjects();
    }

    public Observable<Response> updateProject(Project project){
        return service.updateProject(project.getId(), project);
    }
}
