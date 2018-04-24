package com.japanmicrosystem.equipmentservice.di

import com.japanmicrosystem.equipmentservice.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * UiModule Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
@Module
internal abstract class UiModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity():MainActivity
}