package me.jerryhanks.kotlindagger

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.jerryhanks.kotlindagger.di.AppComponent
import me.jerryhanks.kotlindagger.di.AppInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * @author <@Po10cio> on 10/3/17 for KotlinDagger
 *

 */
class App : Application(), HasActivityInjector {

    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
        @Inject set

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        AppInjector.initInjector(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }
}