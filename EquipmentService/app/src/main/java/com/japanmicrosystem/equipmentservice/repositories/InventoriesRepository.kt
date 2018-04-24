package com.japanmicrosystem.equipmentservice.repositories

import com.japanmicrosystem.equipmentservice.services.InventoriesService

/**
 * InventoriesRepository Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
class InventoriesRepository(private val service:InventoriesService) {
    fun getInventoriesInfo() = service.getInventoriesInfo()
    fun getUser(id:String) = service.getUser(id)
    fun doTransaction(id:String,code:Array<String>) = service.doTransaction(id,code)
}