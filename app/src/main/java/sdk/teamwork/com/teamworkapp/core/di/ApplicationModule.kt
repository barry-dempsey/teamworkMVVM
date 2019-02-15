package sdk.teamwork.com.teamworkapp.core.di

import android.content.Context
import com.dempsey.teamwork.data.net.ApiClient
import com.dempsey.teamwork.service.project.ProjectServiceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sdk.teamwork.com.teamworkapp.core.AUTH_HOST
import sdk.teamwork.com.teamworkapp.core.AndroidApplication
import sdk.teamwork.com.teamworkapp.core.repositories.ProjectsRepository
import javax.inject.Singleton

@Module
class ApplicationModule(private var application: AndroidApplication) {

    @Provides @Singleton fun provideApplicationContext(): Context = application

    @Provides @Singleton fun provideProjectsService(): ProjectServiceImpl = ProjectServiceImpl(ApiClient.Builder().build(), Gson())

    @Provides @Singleton fun provideProjectsRepository(dataSource: ProjectsRepository.Network): ProjectsRepository = dataSource
}