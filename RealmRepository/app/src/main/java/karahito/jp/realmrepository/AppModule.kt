package karahito.jp.realmrepository

import android.app.Application
import android.content.Context
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application:Application){
    @Singleton
    @Provides
    fun provideApplication() = application

    @Singleton
    @Provides
    fun provideContext() = application.applicationContext
}