package com.japanmicrosystem.equipmentservice.di

import com.japanmicrosystem.equipmentservice.repositories.InventoriesRepository
import com.japanmicrosystem.equipmentservice.services.InventoriesService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * RepositoryModule Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
@Module
internal object RepositoryModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideInventoriesRepository(service:InventoriesService) = InventoriesRepository(service)
}