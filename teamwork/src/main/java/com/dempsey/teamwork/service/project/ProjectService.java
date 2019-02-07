package com.dempsey.teamwork.service.project;

import com.dempsey.teamwork.data.model.GetProjectParameter;
import com.dempsey.teamwork.data.model.NewProject;
import com.dempsey.teamwork.data.model.Project;
import com.dempsey.teamwork.data.model.Projects;
import com.dempsey.teamwork.service.RequestCallback;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import java.util.List;

public interface ProjectService {

    void createProject(@NonNull NewProject newProject, @Nullable RequestCallback<okhttp3.Response> callback);
    Observable<okhttp3.Response> createProject(@NonNull NewProject newProject);

    void updateProject(@NonNull String projectId, @NonNull NewProject newProject, @Nullable RequestCallback<okhttp3.Response> callback);
    Observable<okhttp3.Response> updateProject(@NonNull String projectId, @NonNull Project newProject);

    void deleteProject(@NonNull String projectId, @Nullable RequestCallback<okhttp3.Response> callback);
    Observable<okhttp3.Response> deleteProject(@NonNull String projectId);

    void getAllProjects(@Nullable RequestCallback<List<Project>> callback);
    Observable<Projects> getAllProjects();

    void getAllProjects(@Nullable GetProjectParameter getProjectParameter, @Nullable RequestCallback<List<Project>> callback);
    Observable<List<Project>> getAllProjects(@Nullable GetProjectParameter getProjectParameter);

    void getProject(@NonNull String projectId, @Nullable RequestCallback<Project> callback);
    Observable<Project> getProject(@NonNull String projectId);

    void getProject(@NonNull String projectId, boolean includePeople, @Nullable RequestCallback<Project> callback);
    Observable<Project> getProject(@NonNull String projectId, boolean includePeople);

    void getCompanyProjects(@NonNull String companyId, @Nullable RequestCallback<List<Project>> callback);
    Observable<List<Project>> getCompanyProjects(@NonNull String companyId);

    void getStarredProjects(@Nullable RequestCallback<List<Project>> callback);
    Observable<List<Project>> getStarredProjects();

    void starProject(@NonNull String projectId, @Nullable RequestCallback<okhttp3.Response> callback);
    Observable<okhttp3.Response> starProject(@NonNull String projectId);

    void unstarProject(@NonNull String projectId, @Nullable RequestCallback<okhttp3.Response> callback);
    Observable<okhttp3.Response> unstarProject(@NonNull String projectId);

}
