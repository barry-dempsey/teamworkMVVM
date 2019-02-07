package sdk.teamwork.com.teamworkapp.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sdk.teamwork.com.teamworkapp.core.AUTH_HOST
import sdk.teamwork.com.teamworkapp.core.AndroidApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private var application: AndroidApplication) {

    @Provides @Singleton fun provideApplicationContext(): Context = application

    @Provides @Singleton fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AUTH_HOST)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        return okHttpClientBuilder.build()
    }
}