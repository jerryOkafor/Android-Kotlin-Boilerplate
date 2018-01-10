package me.jerryhanks.kotlindagger.di

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import me.jerryhanks.kotlindagger.App
import me.jerryhanks.kotlindagger.util.SimpleActivityLifecycleCallbacks
import timber.log.Timber

/**
 * Created by <@Po10cio> on 8/8/17 for KotlinDagger
 */

class AppInjector {

    companion object {
        fun initInjector(app: App) {
            DaggerAppComponent.builder()
                    .application(app)
                    .appModule(AppModule(app))
                    .build()
                    .apply { app.appComponent = this }
                    .inject(app)

            app.registerActivityLifecycleCallbacks(object : SimpleActivityLifecycleCallbacks() {
                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    handleActivity(activity)
                }
            })
        }

        fun handleActivity(activity: Activity) {
            if (activity is HasSupportFragmentInjector) {
                Timber.d("Activity created: %s", activity.javaClass.simpleName)
                AndroidInjection.inject(activity)
            }

            (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {

                override fun onFragmentAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
                    if (f is Injectable) {
                        AndroidSupportInjection.inject(f)
                    }

                    f?.childFragmentManager?.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true)
                }
            }, true)
        }
    }
}
