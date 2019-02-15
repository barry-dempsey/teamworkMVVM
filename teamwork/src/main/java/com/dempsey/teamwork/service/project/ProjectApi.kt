package com.dempsey.teamwork.service.project

import com.dempsey.teamwork.data.model.Projects
import retrofit2.Call
import retrofit2.http.GET

const val PROJECTS_URL_PATH = "/projects.json"

interface ProjectApi {

    @GET(PROJECTS_URL_PATH)
    fun getAllProjects(): Call<Projects>

}