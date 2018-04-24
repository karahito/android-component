package karahito.jp.realmrepository

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import karahito.jp.realmrepository.component.Injector
import karahito.jp.realmrepository.dto.Inventory
import karahito.jp.realmrepository.repository.RealmRepository
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    init{
        Injector.getAppComponent().inject(this)
    }
    @Inject lateinit var repository:RealmRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        repository.addFromJson(Inventory::class.java,application.resources.assets.open("inventory.json"))
        val inventory = Inventory("00000","smaple","sample","sample","20180424")
        repository.add(inventory)
        Timber.d("${repository.findAll(Inventory::class.java)}")

    }
}
