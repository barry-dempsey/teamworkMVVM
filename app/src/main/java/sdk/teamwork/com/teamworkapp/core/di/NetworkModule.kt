package sdk.teamwork.com.teamworkapp.core.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sdk.teamwork.com.teamworkapp.core.AUTH_HOST
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(AUTH_HOST)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun createClient(): OkHttpClient = OkHttpClient()

}