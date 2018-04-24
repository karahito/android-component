package com.japanmicrosystem.equipmentservice

import com.squareup.moshi.Json

/**
 * Equipment Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
data class Equipment(
        @Json(name = "c")
        val code:String,
        @Json(name = "a")
        val admin:String,
        @Json(name ="n")
        val name:String,
        @Json(name = "u")
        val updater:String?,
        @Json(name = "d")
        val date:String?
)