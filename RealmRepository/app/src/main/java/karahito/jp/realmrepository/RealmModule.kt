package karahito.jp.realmrepository

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(AppModule::class)])
class RealmModule {
    @Singleton
    @Provides
    fun provideRealm(application: Application) = (application as MyApplication).getRealm()
}