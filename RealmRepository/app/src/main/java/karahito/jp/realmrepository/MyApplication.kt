package karahito.jp.realmrepository

import android.app.Application
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.realm.Realm
import io.realm.RealmConfiguration
import karahito.jp.realmrepository.component.Injector
import karahito.jp.realmrepository.dto.Inventory
import okio.BufferedSource
import org.json.JSONObject
import timber.log.Timber
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class MyApplication:Application() {

    private lateinit var realm:Realm
    fun getRealm() = realm

    private fun initRealm():Realm{
        Realm.init(this)
        initRealmConfiguration()
        return Realm.getDefaultInstance()
    }
    private fun initRealmConfiguration(){
        val realmConfig = RealmConfiguration.Builder()
                .name("inventories.realm")
                .initialData(InventoryTransaction(this))
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfig)
    }

    private fun initDagger(){
        Injector.initAppComponent(this)
        Injector.getAppComponent().inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()

        realm = initRealm()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}