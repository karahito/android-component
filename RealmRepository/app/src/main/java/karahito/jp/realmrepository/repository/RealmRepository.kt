package karahito.jp.realmrepository.repository

import dagger.Module
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import karahito.jp.realmrepository.RealmModule
import java.io.InputStream
import javax.inject.Inject

/**
 *  RealmRepository
 *
 *  当Repositoryに格納されるサービスインターフェイスを定義
 *  実装は当Interfaceを継承したinternal classで行う。
 */
interface RealmRepository{
    fun close()
    fun <T:RealmObject>add(model:T):T
    fun <T:RealmObject>findAll(clazz: Class<T>):RealmResults<T>
    fun <T:RealmObject>addFromJson(clazz: Class<T>,json:InputStream):Class<T>
}

