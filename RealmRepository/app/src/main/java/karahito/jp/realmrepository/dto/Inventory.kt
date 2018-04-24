package karahito.jp.realmrepository.dto

import com.squareup.moshi.Json
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField

/**
 * Inventory Class
 *
 * @author D.Noguchi
 * @since 2018/04/23
 */
open class Inventory(
        @PrimaryKey
        @Json(name ="c")
        open var code:String = "",
        @Json(name = "a")
        open var admin:String = "",
        @Json(name="n")
        open var name:String = "",
        @Json(name="u")
        open var updater:String = "",
        @Json(name="d")
        open var date:String = ""
):RealmObject()