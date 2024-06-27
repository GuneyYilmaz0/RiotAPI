package net.guneyilmaz0.riotapi

import com.google.gson.Gson
import com.google.gson.JsonParser
import net.guneyilmaz0.riotapi.enums.Region
import net.guneyilmaz0.riotapi.enums.Server
import net.guneyilmaz0.riotapi.objects.Account
import net.guneyilmaz0.riotapi.objects.match.Match

@Suppress("unused")
class RiotAPI(private val apiKey: String, private val region: Region, private val server: Server) {
    fun getAccountByNameAndTag(name: String, tag: String) : Account {
        val url = "https://${region.code}.api.riotgames.com/riot/account/v1/accounts/by-riot-id/${name.replace(" ", "%20")}/$tag?api_key=$apiKey"
        val json = JsonParser.parseString(Utils.getJsonFromUrl(url))
        return Gson().fromJson(json, Account::class.java)
    }

    fun getMatchIdsByAccount(account: Account) : List<String> {
        val url = "https://${region.code}.api.riotgames.com/lol/match/v5/matches/by-puuid/${account.puuid}/ids?start=0&count=20&api_key=$apiKey"
        val json = JsonParser.parseString(Utils.getJsonFromUrl(url))
        return json.asJsonArray.map { it.asString }
    }

    fun getMatchById(id: String) : Match {
        val url = "https://${region.code}.api.riotgames.com/lol/match/v5/matches/$id?api_key=$apiKey"
        val json = JsonParser.parseString(Utils.getJsonFromUrl(url))
        return Gson().fromJson(json, Match::class.java)
    }

    fun getLatestMatchByAccount(account: Account) : Match = getMatchById(getMatchIdsByAccount(account)[0])

}