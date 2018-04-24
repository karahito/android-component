package karahito.jp.realmrepository.repository

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import karahito.jp.realmrepository.RealmModule
import karahito.jp.realmrepository.dto.Inventory
import timber.log.Timber
import java.io.InputStream
import javax.inject.Inject

/**
 * RealmRepositoryImp Class
 *
 * RealmRepositoryの実装
 *
 * @param realm :Realm
 *
 * @author D.Noguchi
 * @since 2018/04/24
 */

@Module(includes = arrayOf(RealmModule::class))
class RealmRepositoryImp @Inject constructor(private val realm:Realm):RealmRepository {
    override fun close() {
        Timber.d("$realm is close")
        realm.close()
    }

    override fun <T : RealmObject> add(model: T): T {
        Timber.d("add to $realm")
        realm.run {
            beginTransaction()
            copyToRealm(model)
            commitTransaction()
        }
        return model
    }

    override fun <T : RealmObject> findAll(clazz: Class<T>): RealmResults<T> {
        Timber.d("find all object on $realm")
        return realm.where(clazz).findAll()
    }

    override fun <T : RealmObject> addFromJson(clazz: Class<T>, json:InputStream): Class<T> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        realm.run {
            beginTransaction()
            addFromJson(Inventory::class.java,json)
            commitTransaction()
        }
        return clazz
    }

}