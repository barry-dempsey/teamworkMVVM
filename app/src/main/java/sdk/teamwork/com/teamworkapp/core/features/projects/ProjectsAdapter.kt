package sdk.teamwork.com.teamworkapp.core.features.projects

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.dempsey.teamwork.data.model.Project
import sdk.teamwork.com.teamworkapp.R

class ProjectsAdapter(
        private val projects: List<Project>
) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_project_item, parent, false)
        return ProjectViewHolder(view)
    }

    override fun getItemCount() = projects.size

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) =
        holder.bind(projects[position])

    inner class ProjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var rootView = view.findViewById<LinearLayout>(R.id.item_view)
        private var projectDateTv = view.findViewById(R.id.project_date) as TextView
        private var projectNameTv = view.findViewById(R.id.project_name) as TextView
        private var projectStatusTv = view.findViewById(R.id.project_description) as TextView

        fun bind(project: Project) {
            //projectDateTv.text = DateUtil.getPrettyDateFromStamp(project.createdOn)
            projectNameTv.text = project.name
            projectStatusTv.text = project.status
        }

    }

    interface ProjectSelected {

        fun onProjectSelectedForTasks(project: Project)

        fun onProjectSelectedForDetail(project: Project) : Boolean

    }
}