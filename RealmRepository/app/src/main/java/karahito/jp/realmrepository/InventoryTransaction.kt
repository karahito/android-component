package karahito.jp.realmrepository

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.realm.Realm
import karahito.jp.realmrepository.dto.Inventory
import javax.inject.Inject

/**
 * InventoryTransaction Class
 *
 * @author D.Noguchi
 * @since 2018/04/24
 */
class InventoryTransaction @Inject constructor(private val application: MyApplication): Realm.Transaction {
    override fun execute(realm: Realm?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        realm.let {
            application.let { source ->
                val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                it?.createAllFromJson(Inventory::class.java,source.resources.assets.open("inventory.json"))
            }
        }
    }

}