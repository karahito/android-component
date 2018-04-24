package com.japanmicrosystem.equipmentservice.application.di

import com.japanmicrosystem.equipmentservice.application.MyApplication
import com.japanmicrosystem.equipmentservice.di.DateModule
import com.japanmicrosystem.equipmentservice.di.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (DateModule::class),
    (UiModule::class)
])
interface AppComponent:AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:MyApplication):Builder
        fun build():AppComponent
    }
}