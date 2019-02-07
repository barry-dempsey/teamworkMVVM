package sdk.teamwork.com.teamworkapp.core.features.projects

import android.os.Bundle
import com.dempsey.teamwork.data.model.Project
import sdk.teamwork.com.teamworkapp.R
import sdk.teamwork.com.teamworkapp.core.platform.BaseFragment

class ProjectsFragment : BaseFragment(){

    private var projectList: List<Project>? = null

    override fun layoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProjectsFragment()
    }
}