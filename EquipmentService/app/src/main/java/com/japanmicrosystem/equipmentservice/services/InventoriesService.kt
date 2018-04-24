package com.japanmicrosystem.equipmentservice.services

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface InventoriesService {
    @GET("/inventories/?einfo=1")
    fun getInventoriesInfo(): Observable<ResponseBody>

    @GET("/inventories")
    fun getUser(@Query("WCODE") id: String): Single<ResponseBody>

    @GET("/inventories")
    fun doTransaction(@Query("WCODE", encoded = true) id: String, @Query("ECODE", encoded = true) code: Array<String>): Single<ResponseBody>

}