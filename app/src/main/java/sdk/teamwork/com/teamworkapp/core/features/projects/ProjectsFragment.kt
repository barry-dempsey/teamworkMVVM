package sdk.teamwork.com.teamworkapp.core.features.projects

import android.os.Bundle
import com.dempsey.teamwork.data.model.Projects
import sdk.teamwork.com.teamworkapp.R
import sdk.teamwork.com.teamworkapp.core.extension.failure
import sdk.teamwork.com.teamworkapp.core.extension.observe
import sdk.teamwork.com.teamworkapp.core.extension.viewModel
import sdk.teamwork.com.teamworkapp.core.platform.BaseFragment

class ProjectsFragment : BaseFragment(){

    private lateinit var projectsViewModel: ProjectsViewModel

    override fun layoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setHasOptionsMenu(true)
        projectsViewModel.startProjectsUseCase()
    }

    override fun setupViewModel() {
        projectsViewModel = viewModel(viewModelFactory){
            observe(projectsData, ::updateProjectsData)
            failure(failure){
                handleFailure(it!!)
            }
        }
    }

    private fun updateProjectsData(projects: Projects?) {
        val adapter = ProjectsAdapter(projects!!.projectList)

    }

    companion object {
        @JvmStatic
        fun newInstance() = ProjectsFragment()
    }
}