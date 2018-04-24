package com.japanmicrosystem.equipmentservice.application

import android.app.Application
import com.japanmicrosystem.equipmentservice.BuildConfig
import com.japanmicrosystem.equipmentservice.application.di.AppComponent
import com.japanmicrosystem.equipmentservice.application.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * MyApplication Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
class MyApplication: DaggerApplication(){

//    private lateinit var component: AppComponent
//
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder()
            .application(this)
            .build()


    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}