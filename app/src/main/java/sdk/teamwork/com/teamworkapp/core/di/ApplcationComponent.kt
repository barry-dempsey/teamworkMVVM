package sdk.teamwork.com.teamworkapp.core.di

import dagger.Component
import sdk.teamwork.com.teamworkapp.core.AndroidApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
}