package net.guneyilmaz0.riotapi

import com.google.gson.Gson
import com.google.gson.JsonParser
import net.guneyilmaz0.riotapi.enums.Region
import net.guneyilmaz0.riotapi.enums.Server
import net.guneyilmaz0.riotapi.objects.Account
import net.guneyilmaz0.riotapi.objects.match.Match

@Suppress("unused")
class RiotAPI(private val apiKey: String, private val region: Region, private val server: Server) {

    private val gson = Gson()

    fun getAccountByNameAndTag(string: String): Account {
        val (name, tag) = string.split("#")
        return getAccountByNameAndTag(name, tag)
    }

    fun getAccountByNameAndTag(name: String, tag: String): Account {
        val formattedName = name.replace(" ", "%20")
        val url = buildUrl(
            "${region.code}.api.riotgames.com",
            "riot/account/v1/accounts/by-riot-id/$formattedName/$tag"
        )
        val json = Utils.getJsonFromUrl(url)
        return gson.fromJson(JsonParser.parseString(json), Account::class.java)
    }

    fun getMatchIdsByAccount(account: Account): List<String> {
        val url = buildUrl(
            "${region.code}.api.riotgames.com",
            "lol/match/v5/matches/by-puuid/${account.puuid}/ids",
            "start=0&count=20"
        )
        val json = Utils.getJsonFromUrl(url)
        return JsonParser.parseString(json).asJsonArray.map { it.asString }
    }

    fun getMatchById(id: String): Match {
        val url = buildUrl(
            "${region.code}.api.riotgames.com",
            "lol/match/v5/matches/$id"
        )
        val json = Utils.getJsonFromUrl(url)
        return gson.fromJson(JsonParser.parseString(json), Match::class.java)
    }

    fun getLatestMatchByAccount(account: Account): Match {
        val matchIds = getMatchIdsByAccount(account)
        if (matchIds.isNotEmpty()) return getMatchById(matchIds[0])
        else throw NoSuchElementException("No matches found for account: ${account.puuid}")
    }

    private fun buildUrl(base: String, endpoint: String, query: String = ""): String {
        return if (query.isEmpty()) "https://$base/$endpoint?api_key=$apiKey"
        else "https://$base/$endpoint?$query&api_key=$apiKey"
    }
}