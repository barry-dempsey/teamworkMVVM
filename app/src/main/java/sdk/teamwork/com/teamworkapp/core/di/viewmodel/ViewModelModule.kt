package sdk.teamwork.com.teamworkapp.core.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sdk.teamwork.com.teamworkapp.core.features.projects.ProjectsViewModel
import sdk.teamwork.com.teamworkapp.core.features.TasksViewModel

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProjectsViewModel::class)
    abstract fun bindsProjectsViewModel(projectsViewModel: ProjectsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    abstract fun bindsTasksViewModel(tasksViewModel: TasksViewModel): ViewModel
}