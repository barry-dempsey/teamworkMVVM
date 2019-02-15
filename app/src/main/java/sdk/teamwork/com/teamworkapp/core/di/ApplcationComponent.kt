package sdk.teamwork.com.teamworkapp.core.di

import dagger.Component
import sdk.teamwork.com.teamworkapp.core.AndroidApplication
import sdk.teamwork.com.teamworkapp.core.di.viewmodel.ViewModelModule
import sdk.teamwork.com.teamworkapp.core.platform.BaseActivity
import sdk.teamwork.com.teamworkapp.core.platform.BaseFragment
import sdk.teamwork.com.teamworkapp.core.repositories.ProjectsRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
    fun inject(baseFragment: BaseFragment)
    fun inject(baseActivity: BaseActivity)
    fun inject(repository: ProjectsRepository)
}