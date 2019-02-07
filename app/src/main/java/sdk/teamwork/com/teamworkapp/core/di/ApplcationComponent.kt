package sdk.teamwork.com.teamworkapp.core.di

import dagger.Component
import sdk.teamwork.com.teamworkapp.core.AndroidApplication
import sdk.teamwork.com.teamworkapp.core.platform.BaseActivity
import sdk.teamwork.com.teamworkapp.core.platform.BaseFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
    fun inject(baseFragment: BaseFragment)
    fun inject(baseActivity: BaseActivity)
}