package com.praving.bareztechecom

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


/* declare hilt annotation for hilt-dagger di*/
@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /* Enable timber logs only for debug build*/
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}