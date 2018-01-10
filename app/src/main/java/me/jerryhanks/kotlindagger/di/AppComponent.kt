package me.jerryhanks.kotlindagger.di

import android.app.Application

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import me.jerryhanks.kotlindagger.App

/**
 * Created by <@Po10cio> on 8/8/17 for KotlinDagger
 */

@Singleton
@Component(modules = [AppModule::class, BuildersModule::class, AndroidSupportInjectionModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

    //create injection of other objects
}
