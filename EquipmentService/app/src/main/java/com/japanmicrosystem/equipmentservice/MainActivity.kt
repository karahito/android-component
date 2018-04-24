package com.japanmicrosystem.equipmentservice

import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.japanmicrosystem.equipmentservice.databinding.ActivityMainBinding
import com.japanmicrosystem.equipmentservice.repositories.InventoriesRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import pl.droidsonroids.jspoon.Jspoon
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: InventoriesRepository
    @Inject
    lateinit var moshi: Moshi



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val equipment = ObservableArrayList<Equipment>()
        val header = View.inflate(this,R.layout.header_list_equipment,null)
        binding.listView.addHeaderView(header)
        binding.info = equipment
        AndroidInjection.inject(this)

        repository.getUser("000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val user = it.parse()
                    user?.name?.let {
                        Timber.d(it)
                    }?:Timber.d(user?.error?.component1())
                },{
                    Timber.e(it)
                })
        repository.getInventoriesInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                    Timber.d(it.string())
                    var json = JsonFromHtml().parse(it)
                    json = "[$json]"
                    val listMyDate = Types.newParameterizedType(List::class.java,Equipment::class.java)
                    val adapter: JsonAdapter<List<Equipment>> = moshi.adapter(listMyDate)
                    val buff = adapter.fromJson(json)
//                    Timber.d("$equipmentbuff")
                    buff?.forEach {
                        equipment.add(it)
                    }
                    binding.listView.setAdapter(equipment)
                },{
                    Timber.e(it)
                })
    }

    fun ResponseBody.toDocument():Document? = Jsoup.parse(this.string())
    fun JsonFromHtml.parse(htmlContents:ResponseBody):String?{
        htmlContents.toDocument()?.let {
            return Jspoon.create().adapter(this::class.java).fromHtml(it.html()).json
        } ?: return null
    }

    fun ResponseBody.parse():User?{
        val html = Jsoup.parse(this.string()).html()
        val jsonFromHtmlAdapter = Jspoon.create().adapter(JsonFromHtml::class.java)
        val json = jsonFromHtmlAdapter.fromHtml(html).json
        json?.let {
            return moshi.adapter(User::class.java).fromJson(json)
        } ?: return null
    }
}
