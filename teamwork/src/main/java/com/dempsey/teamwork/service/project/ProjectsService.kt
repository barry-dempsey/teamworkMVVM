package com.dempsey.teamwork.service.project

import com.dempsey.teamwork.data.model.Projects
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectsService @Inject constructor(
    retrofit: Retrofit
): ProjectApi {
    private val projectApi by lazy { retrofit.create(ProjectApi::class.java) }
    override fun getAllProjects(): Call<Projects> = projectApi.getAllProjects()
}