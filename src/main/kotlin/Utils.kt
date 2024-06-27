package net.guneyilmaz0.riotapi

import com.google.gson.Gson
import com.google.gson.JsonParser
import net.guneyilmaz0.riotapi.enums.Language
import net.guneyilmaz0.riotapi.enums.ResponseCode
import net.guneyilmaz0.riotapi.objects.champion.Champion
import java.net.HttpURLConnection
import java.net.URI

@Suppress("unused")
object Utils {
    fun getJsonFromUrl(url: String): String {
        val connection = (URI(url).toURL().openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
        }
        return connection.inputStream.bufferedReader().use { reader ->
            val responseCode = connection.responseCode
            if (responseCode != HttpURLConnection.HTTP_OK) throw RuntimeException(ResponseCode.fromCode(responseCode).message)
            reader.readText()
        }
    }

    fun getLatestLOLVersion(): String {
        TempMemory.latestLOLVersion?.let { return it }
        val url = "${TempMemory.dataDragonURL}/api/versions.json"
        val version = JsonParser.parseString(getJsonFromUrl(url)).asJsonArray[0].asString
        TempMemory.latestLOLVersion = version
        return version
    }

    fun getChampionByName(champion: String, language: Language): Champion {
        val url = "${TempMemory.dataDragonURL}/cdn/${getLatestLOLVersion()}/data/${language.code}/champion/$champion.json"
        val json = JsonParser.parseString(getJsonFromUrl(url)).asJsonObject["data"].asJsonObject[champion]
        return Gson().fromJson(json, Champion::class.java)
    }

    fun getChampionSquareAsset(championName: String): String =
        "${TempMemory.dataDragonURL}/cdn/${getLatestLOLVersion()}/img/champion/$championName.png"

    fun getChampionLoadingScreenAsset(championName: String): String =
        "${TempMemory.dataDragonURL}/cdn/${getLatestLOLVersion()}/img/loading/${championName}_0.jpg"

    fun getItemAsset(itemId: Int): String =
        "${TempMemory.dataDragonURL}/cdn/${getLatestLOLVersion()}/img/item/$itemId.png"

    fun getProfileIconAsset(iconId: Int): String =
        "${TempMemory.dataDragonURL}/cdn/${getLatestLOLVersion()}/img/profileicon/$iconId.png"
}
