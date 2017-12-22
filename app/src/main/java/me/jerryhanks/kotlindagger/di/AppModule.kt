package me.jerryhanks.kotlindagger.di


import android.content.Context
import dagger.Module
import dagger.Provides
import me.jerryhanks.kotlindagger.App
import me.jerryhanks.kotlindagger.data.DataSource
import me.jerryhanks.kotlindagger.data.Repository
import me.jerryhanks.kotlindagger.data.remote.AppApiService
import me.jerryhanks.kotlindagger.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by <@Po10cio> on 8/8/17 for KotlinDagger
 *
 */

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    internal fun provideContext(): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideDataSource(apiService: AppApiService): DataSource {
        return Repository(apiService)
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/po10cio/MockServer/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .build()

    }

    @Singleton
    @Provides
    internal fun prvideApiServie(retrofit: Retrofit): AppApiService {
        return retrofit.create(AppApiService::class.java)
    }


}
