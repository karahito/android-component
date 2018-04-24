package karahito.jp.realmrepository.component

import karahito.jp.realmrepository.AppModule
import karahito.jp.realmrepository.MyApplication
import karahito.jp.realmrepository.RealmModule
import java.util.*
import javax.inject.Singleton

/**
 * Injector
 *
 * @author D.Noguchi
 * @since 2018/04/24
 */
object Injector {

    private lateinit var appComponent: AppComponent
    @Singleton
    fun initAppComponent(application: MyApplication){
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .realmModule(RealmModule())
                .build()
    }

    fun getAppComponent():AppComponent{
        Objects.requireNonNull(appComponent,"component is null")
        return appComponent
    }

}