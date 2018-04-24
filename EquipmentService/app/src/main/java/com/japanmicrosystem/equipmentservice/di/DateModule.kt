package com.japanmicrosystem.equipmentservice.di

import com.japanmicrosystem.equipmentservice.services.InventoriesService
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * DateModule Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
@Module(includes = [(RepositoryModule::class)])
class DateModule {
    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()!!



    @Singleton
    @Provides
    fun provideOkHttp():OkHttpClient = OkHttpClient.Builder()
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,moshi: Moshi):Retrofit =
        Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://192.168.1.11")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    @Singleton
    @Provides
    fun provideInventoriesService(retrofit: Retrofit) = retrofit.create(InventoriesService::class.java)

}