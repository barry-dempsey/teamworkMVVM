package sdk.teamwork.com.teamworkapp.core

import android.app.Application
import sdk.teamwork.com.teamworkapp.core.di.ApplicationComponent
import sdk.teamwork.com.teamworkapp.core.di.ApplicationModule
import sdk.teamwork.com.teamworkapp.core.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}