package sdk.teamwork.com.teamworkapp.core.features.projects

import android.arch.lifecycle.MutableLiveData
import com.dempsey.teamwork.data.model.Projects
import sdk.teamwork.com.teamworkapp.core.platform.BaseViewModel
import javax.inject.Inject

class ProjectsViewModel @Inject constructor(
    private val projectsUseCase: ProjectsUseCase
) : BaseViewModel() {

    val projectsData: MutableLiveData<Projects> = MutableLiveData()

    fun startProjectsUseCase() {
        projectsUseCase(params = Unit)
        { it.either(::handleFailure, ::handleProjects)}
    }

    private fun handleProjects(projects: Projects) {
        projectsData.postValue(projects)
    }
}
