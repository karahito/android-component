package karahito.jp.realmrepository.component

import dagger.Component
import karahito.jp.realmrepository.AppModule
import karahito.jp.realmrepository.MainActivity
import karahito.jp.realmrepository.MyApplication
import karahito.jp.realmrepository.RealmModule
import karahito.jp.realmrepository.repository.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        RepositoryModule::class,
        AppModule::class,
        RealmModule::class))
interface AppComponent {
    fun inject(application: MyApplication)
    fun inject(activity: MainActivity)
}