package karahito.jp.realmrepository.dto

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SampleDto(
        @PrimaryKey var key:String = ""
):RealmObject()