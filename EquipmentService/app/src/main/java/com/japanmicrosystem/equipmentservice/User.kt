package com.japanmicrosystem.equipmentservice

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi

/**
 * User Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */

data class User(
//        @SerializedName("NAME")
    @Json(name = "NAME")
    var name:String?,
    @Json(name = "ERROR")
    var error:List<String>?
){
    fun String.toUser(moshi:Moshi):User?{
        return moshi.adapter(User::class.java).fromJson(this)
    }
}