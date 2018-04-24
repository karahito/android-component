package com.japanmicrosystem.equipmentservice

import okhttp3.ResponseBody
import org.jsoup.Jsoup
import pl.droidsonroids.jspoon.Jspoon
import pl.droidsonroids.jspoon.annotation.Selector

/**
 * JsonFromHtml Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
class JsonFromHtml {
    @Selector("body") var json:String? = null

    fun ResponseBody.toJson():String?{
        val html = Jsoup.parse(this.string()).html()
        return Jspoon.create().adapter(JsonFromHtml::class.java).fromHtml(html).json
    }


}